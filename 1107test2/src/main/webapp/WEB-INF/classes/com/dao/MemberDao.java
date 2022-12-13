package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.domain.Member;

public class MemberDao {
    
        
/*    @싱글턴 패턴
    생성자의 접근지정자는 private으로 지정
    static한 getInstance()를  메소드를 사용
    객체의 주소를 보관하는 static 참조변수 사용 
      //참조변수 instance에 객체 주소할당
      //객체를 한번생성해서 계속가지고있슴 (변경에관한게 아무것도없슴)
    객체를 하나만 생성해서 공유하고자 싱글턴 패턴 구현
    @멤버변수가 있는 경우에는 절대로 싱글턴 패턴을 구현하면 안된다.
      //멤버변수를 공유시켜버리면 여러사용자가 멤버변수를 같이 변경하게됨    */
    private static MemberDao instance =new MemberDao();
    
    public static MemberDao getInstance(){
        return instance;
    }

    //생성자 인데 private 외부에서는 생성못하게 막아둔거
    //메소드를 static 하게만들어  메서드를  이용해서 
    //Member.getInstance();
    private MemberDao(){
    }
    
    //커네션풀로 부터 커넥션을 할당 받는 메소드
    private Connection getConnection() throws Exception{
        Context initCtx= new InitialContext();
        Context envCtx=(Context)initCtx.lookup("java:comp/env");
        DataSource ds=(DataSource)envCtx.lookup("jdbc/OracleDB");
        
        return ds.getConnection();
    }
    
    //회원가입
    public void insertMember(Member member)throws Exception{
        Connection conn= null;
        PreparedStatement pstmt = null;
        String sql="";
        int cnt = 0;
        
        try{
            //커넥션 풀로 부터 커넥션 할당
            conn= getConnection();
            sql ="insert into MEMBER values(?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(++cnt, member.getId());
            pstmt.setString(++cnt, member.getPasswd());
            pstmt.setString(++cnt, member.getName());
            pstmt.setString(++cnt, member.getJumin1());
            pstmt.setString(++cnt, member.getJumin2());
            pstmt.setString(++cnt, member.getEmail());
            pstmt.setString(++cnt, member.getBlog());
            pstmt.setTimestamp(++cnt, member.getReg_date());
            pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            execClose(null,pstmt,conn);
        }
    }
    
    //회원 아이디 , 비밀번호 체크
    public int userCheck(String id, String passwd)throws Exception{
        
        Connection conn= null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        String sql="";
        String dbpasswd="";
        int x = -1;
        
        try{
            conn =getConnection();
            sql ="select passwd from MEMBER where id = ?";
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs=pstmt.executeQuery();
            
            if(rs.next()){
                dbpasswd =rs.getString("passwd");
                if(dbpasswd.equals(passwd))
                    x=1; //인증성공
                else
                    x=0; //비밀번호 틀림
            }else
                x=-1; //해당 아이디 없음
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            execClose(rs,pstmt,conn);
        }
        return x;
    }
    
    //회원 상세정보 
    public Member getMember(String id)throws Exception{
        Connection conn =null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Member member=null;
        String sql="";
        try{
            conn=getConnection();
            sql="select * from MEMBER where id= ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs= pstmt.executeQuery();
            
            if(rs.next()){
                member=new Member();
                member.setId(rs.getString("id"));
                member.setPasswd(rs.getString("passwd"));
                member.setName(rs.getString("name"));
                member.setJumin1(rs.getString("jumin1"));
                member.setJumin2(rs.getString("jumin2"));
                member.setEmail(rs.getString("email"));
                member.setBlog(rs.getString("blog"));
                member.setReg_date(rs.getTimestamp("reg_date"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            execClose(rs,pstmt,conn);
        }
        return member;
    }
    
    //회원정보 수정
    public void updateMember(Member member)throws Exception{
        Connection conn=null;
        PreparedStatement pstmt =null;
        String sql = null;
        int cnt =0;
        try{
            conn =getConnection();
            sql = "update MEMBER set passwd=?,name=?,email=?, blog=? where id=?";
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(++cnt, member.getPasswd());
            pstmt.setString(++cnt, member.getName());
            pstmt.setString(++cnt, member.getEmail());
            pstmt.setString(++cnt, member.getBlog());
            pstmt.setString(++cnt, member.getId());
            
            pstmt.executeUpdate();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            execClose(null,pstmt,conn);
        }
    }   
    
    //회원탈퇴 , 회원정보 삭제
    public void deleteMember(String id)throws Exception{
        Connection conn=null;
        PreparedStatement pstmt =null;
        String sql = null;
        try{
            conn =getConnection();
            sql = "delete from MEMBER where id=?";
            pstmt =conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            execClose(null,pstmt,conn);
        }
    }
    
    //ID 중복 체크
    public int confirmId(String id)throws Exception{
        Connection conn =null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql="";
        int x=-1;
        try{
            conn=getConnection();
            sql="select * from MEMBER where id= ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs= pstmt.executeQuery();    
            
            if(rs.next())
                x=1; //해당아이디 있음
            else
                x=-1;//해당아이디 없음
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            execClose(rs,pstmt,conn);
        }
        
        return x;
    }
    
    //자원 정리를 위한 메소드
    //계란노른자
    //Connection 를통해서 PreparedStatement 를생성하고 
    //PreparedStatement 를 통해서 ResultSet 를 생성하기때문에
    //종료할때는 ResultSet=>PreparedStatement=>Connection 와같이 생성순서의 역순으로 close 해줘야한다
    public void execClose(ResultSet rs, PreparedStatement pstmt, Connection conn)throws Exception{
        //자원정리
        if(rs !=null) try{rs.close();}catch(SQLException sqle){}
        if(pstmt !=null) try{pstmt.close();}catch(SQLException sqle){}
        //커넥션 풀로 반납
        if(conn !=null) try{conn.close();}catch(SQLException sqle){}
    }
}
