package pack_MyPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pack_DBCP.DBConnectionMgr;


public class MyPageDao {
	private Connection objConn = null;
	private Statement objStmt = null;
	private ResultSet objRs = null;
	private PreparedStatement objPStmt = null;
	private DBConnectionMgr pool = null;
	String sql = "";

	public MyPageDao() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			System.out.println("DBCP E:" + e.getMessage());
		} 
	}

	// 주문내역 메서드
	// 주문내역 기간별 조회 기능 추가해야됨
	public List<OrderListBean> selectOrderList(String uId) {
		List<OrderListBean> list = new ArrayList<>();
		try {
			objConn = pool.getConnection();
	         sql = "select * from orderList where uId = ?";
	         objPStmt = objConn.prepareStatement(sql);
	         objPStmt.setString(1, uId);
	         objRs = objPStmt.executeQuery();
			
			while (objRs.next()) {
				OrderListBean orderList = new OrderListBean();
				orderList.setNo(objRs.getInt("no"));
				orderList.setuId(objRs.getString("uId"));
				orderList.setGoodsCode(objRs.getString("goodsCode"));
				orderList.setGoodsCnt(objRs.getInt("goodsCnt"));
				list.add(orderList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(objConn, objPStmt, objRs);
		}
		return list;
	}

	//찜한 목록 메서드
	public List<WishListBean> selectWishList(String uId) {
		List<WishListBean> list = new ArrayList<>();
		try {
			objConn = pool.getConnection();
	         sql = "select * from wishList where uId = ?";
	         objPStmt = objConn.prepareStatement(sql);
	         objPStmt.setString(1, uId);
	         objRs = objPStmt.executeQuery();
			
			while (objRs.next()) {
				WishListBean wishList  = new WishListBean();
				wishList.setNo(objRs.getInt("no"));
				wishList.setuId(objRs.getString("uId"));
				wishList.setGoodsCode(objRs.getString("goodsCode"));
				list.add(wishList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(objConn, objPStmt, objRs);
		}
		return list;
	}
	//찜한 목록 삭제 메서드
	public boolean deleteWishList(String goodsCode) {
		int rs = 0;
		try {
			objConn = pool.getConnection();
	         sql = "delete from wishList where goodsCode = ?";
	         objPStmt = objConn.prepareStatement(sql);
	         objPStmt.setString(1, goodsCode);
	         rs = objPStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(objConn, objPStmt, objRs);
		}
		return rs ==1 ? true : false;
	}
	
	
	// 배송지 추가 메서드 
	public List<AddrBean> insertAddr(String uId) {
		List<AddrBean> list = new ArrayList<>();
		try {
			objConn = pool.getConnection();
	         sql = "insert * from Addr where uId = ?";
	         objPStmt = objConn.prepareStatement(sql);
	         objPStmt.setString(1, uId);
	         objRs = objPStmt.executeQuery();
			
			while (objRs.next()) {
				AddrBean addr  = new AddrBean();
				addr.setNo(objRs.getInt("no"));
				addr.setuId(objRs.getString("uId"));
				addr.setuName(objRs.getString("uName"));
				addr.setuAddr(objRs.getString("uAddr"));
				list.add(addr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(objConn, objPStmt, objRs);
		}
		return list;
	}
	//배송지 삭제 메서드
	public boolean deleteAddr(String addr) {
		int rs = 0;
		try {
			objConn = pool.getConnection();
	         sql = "delete from Addr where addr = ?";
	         objPStmt = objConn.prepareStatement(sql);
	         objPStmt.setString(1, addr);
	         rs = objPStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(objConn, objPStmt);
		}
		return rs==1 ? true : false;
	}
	
	
	//상품 후기 작성 메서드
	public List<GoodsCommentsBean> selectComments(String uId) {
		List<GoodsCommentsBean> list = new ArrayList<>();
		try {
			objConn = pool.getConnection();
	         sql = "select no, uId, goodsCode, title_c from goodsComments where uId = ?";
	         objPStmt = objConn.prepareStatement(sql);
	         objPStmt.setString(1, uId);
	         objRs = objPStmt.executeQuery();
			
			while (objRs.next()) {
				GoodsCommentsBean comments  = new GoodsCommentsBean();
				comments.setNo(objRs.getInt("no"));
				comments.setuId(objRs.getString("uId"));
				comments.setGoodsCode(objRs.getString("goodsCode"));
				comments.setTitle_c(objRs.getString("title_c"));
				list.add(comments);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(objConn, objPStmt, objRs);
		}
		return list;
	}
	
	
	//상품 문의 메서드
	public List<GoodsQnABean> selectQnA(String uId) {
		List<GoodsQnABean> list = new ArrayList<>();
		try {
			objConn = pool.getConnection();
	         sql = "select no, uId, goodsCode, title_q from goodsQnA where uId = ?";
	         objPStmt = objConn.prepareStatement(sql);
	         objPStmt.setString(1, uId);
	         objRs = objPStmt.executeQuery();
			
			while (objRs.next()) {
				GoodsQnABean qna  = new GoodsQnABean();
				qna.setNo(objRs.getInt("no"));
				qna.setuId(objRs.getString("uId"));
				qna.setGoodsCode(objRs.getString("goodsCode"));
				qna.setTitle_q(objRs.getString("title_q"));
				list.add(qna);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(objConn, objPStmt, objRs);
		}
		return list;
	}
	

	
	

}
