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
    
        
/*    @�̱��� ����
    �������� ���������ڴ� private���� ����
    static�� getInstance()��  �޼ҵ带 ���
    ��ü�� �ּҸ� �����ϴ� static �������� ��� 
      //�������� instance�� ��ü �ּ��Ҵ�
      //��ü�� �ѹ������ؼ� ��Ӱ������ֽ� (���濡���Ѱ� �ƹ��͵�����)
    ��ü�� �ϳ��� �����ؼ� �����ϰ��� �̱��� ���� ����
    @��������� �ִ� ��쿡�� ����� �̱��� ������ �����ϸ� �ȵȴ�.
      //��������� �������ѹ����� ��������ڰ� ��������� ���� �����ϰԵ�    */
    private static MemberDao instance =new MemberDao();
    
    public static MemberDao getInstance(){
        return instance;
    }

    //������ �ε� private �ܺο����� �������ϰ� ���Ƶа�
    //�޼ҵ带 static �ϰԸ����  �޼��带  �̿��ؼ� 
    //Member.getInstance();
    private MemberDao(){
    }
    
    //Ŀ�׼�Ǯ�� ���� Ŀ�ؼ��� �Ҵ� �޴� �޼ҵ�
    private Connection getConnection() throws Exception{
        Context initCtx= new InitialContext();
        Context envCtx=(Context)initCtx.lookup("java:comp/env");
        DataSource ds=(DataSource)envCtx.lookup("jdbc/OracleDB");
        
        return ds.getConnection();
    }
    
    //ȸ������
    public void insertMember(Member member)throws Exception{
        Connection conn= null;
        PreparedStatement pstmt = null;
        String sql="";
        int cnt = 0;
        
        try{
            //Ŀ�ؼ� Ǯ�� ���� Ŀ�ؼ� �Ҵ�
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
    
    //ȸ�� ���̵� , ��й�ȣ üũ
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
                    x=1; //��������
                else
                    x=0; //��й�ȣ Ʋ��
            }else
                x=-1; //�ش� ���̵� ����
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            execClose(rs,pstmt,conn);
        }
        return x;
    }
    
    //ȸ�� ������ 
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
    
    //ȸ������ ����
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
    
    //ȸ��Ż�� , ȸ������ ����
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
    
    //ID �ߺ� üũ
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
                x=1; //�ش���̵� ����
            else
                x=-1;//�ش���̵� ����
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            execClose(rs,pstmt,conn);
        }
        
        return x;
    }
    
    //�ڿ� ������ ���� �޼ҵ�
    //����븥��
    //Connection �����ؼ� PreparedStatement �������ϰ� 
    //PreparedStatement �� ���ؼ� ResultSet �� �����ϱ⶧����
    //�����Ҷ��� ResultSet=>PreparedStatement=>Connection �Ͱ��� ���������� �������� close ������Ѵ�
    public void execClose(ResultSet rs, PreparedStatement pstmt, Connection conn)throws Exception{
        //�ڿ�����
        if(rs !=null) try{rs.close();}catch(SQLException sqle){}
        if(pstmt !=null) try{pstmt.close();}catch(SQLException sqle){}
        //Ŀ�ؼ� Ǯ�� �ݳ�
        if(conn !=null) try{conn.close();}catch(SQLException sqle){}
    }
}