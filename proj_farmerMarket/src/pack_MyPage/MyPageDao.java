package pack_MyPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pack_DBCP.DBConnectionMgr;
import pack_Goods.GoodsBean;

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
	public List<GoodsBean> selectOrderList(String uId) {
		List<GoodsBean> list = new ArrayList<>();
		try {
			objConn = pool.getConnection();
			sql = "select g.goodsImg, g.goodsName, g.goodsPrice  from goods g left join orderList on g.goodsCode = orderList.goodsCode where orderList.uid =?";
			objPStmt = objConn.prepareStatement(sql);
			objPStmt.setString(1, uId);
			objRs = objPStmt.executeQuery();

			while (objRs.next()) {
				GoodsBean goods = new GoodsBean();
				goods.setGoodsImg(objRs.getString("goodsImg"));
				goods.setGoodsName(objRs.getString("goodsName"));
				goods.setGoodsPrice(objRs.getInt("goodsPrice"));
				list.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(objConn, objPStmt, objRs);
		}
		return list;
	}

	// 찜한 목록 메서드
	public List<GoodsBean> selectWishList(String uId) {
		List<GoodsBean> list = new ArrayList<>();
		try {

			objConn = pool.getConnection();
			sql = "select g.goodsImg, g.goodsName, g.goodsPrice  from goods g left join wishlist on g.goodsCode = wishlist.goodsCode where wishlist.uid =?";
			objPStmt = objConn.prepareStatement(sql);
			objPStmt.setString(1, uId);
			objRs = objPStmt.executeQuery();

			while (objRs.next()) {
				GoodsBean goods = new GoodsBean();
				goods.setGoodsImg(objRs.getString("goodsImg"));
				goods.setGoodsName(objRs.getString("goodsName"));
				goods.setGoodsPrice(objRs.getInt("goodsPrice"));

				list.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(objConn, objPStmt, objRs);
		}
		return list;
	}

	// 찜한 목록 삭제 메서드
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
		return rs == 1 ? true : false;
	}

	// 배송지 추가 메서드
	public boolean insertAddr(String uId, String uName, String uAddr) {
		boolean flag = false;
		try {
			objConn = pool.getConnection();
			sql = "insert into addr (uId, uName, uAddr) values(?,?,?)";
			objPStmt = objConn.prepareStatement(sql);
			objPStmt.setString(1, uId);
			objPStmt.setString(2, uName);
			objPStmt.setString(3, uAddr);

			if (objPStmt.executeUpdate() == 1) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(objConn, objPStmt);
		}
		return flag;
	}

	// 배송지 삭제 메서드
	public boolean deleteAddr(String uId, String no) {
		int result = 0;
		try {
			objConn = pool.getConnection();
			sql = "delete from Addr where uid=? and no = ?";
			objPStmt = objConn.prepareStatement(sql);
			
			int num = Integer.parseInt(no);
			objPStmt.setString(1, uId);
			objPStmt.setInt(2, num);
			result = objPStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(objConn, objPStmt);
		}
		return result == 1 ? true : false;
	}

	// addr테이블에 저장된 배송지 다 가져오기
	public List<AddrBean> selectAddrList(String uId) {
		List<AddrBean> list = new ArrayList<>();
		try {
			objConn = pool.getConnection();
			sql = "select * from Addr where uId = ?";
			objPStmt = objConn.prepareStatement(sql);
			objPStmt.setString(1, uId);
			objRs = objPStmt.executeQuery();
			
			while (objRs.next()) {
				AddrBean aBean = new AddrBean();
				aBean.setNo(objRs.getInt("no"));
				aBean.setuId(objRs.getString("uId"));
				aBean.setuName(objRs.getString("uName"));
				aBean.setuAddr(objRs.getString("uAddr"));
				list.add(aBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(objConn, objPStmt);
		}
		return list;
	}

	// 상품 후기 작성 메서드
	public List<GoodsCommentsBean> selectComments(String uId) {
		List<GoodsCommentsBean> list = new ArrayList<>();
		try {
			objConn = pool.getConnection();
			sql = "select no, uId, goodsCode, title_c from goodsComments where uId = ?";
			objPStmt = objConn.prepareStatement(sql);
			objPStmt.setString(1, uId);
			objRs = objPStmt.executeQuery();

			while (objRs.next()) {
				GoodsCommentsBean comments = new GoodsCommentsBean();
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

	// 상품 문의 메서드
	public List<GoodsQnABean> selectQnA(String uId) {
		List<GoodsQnABean> list = new ArrayList<>();
		try {
			objConn = pool.getConnection();
			sql = "select no, uId, goodsCode, title_q from goodsQnA where uId = ?";
			objPStmt = objConn.prepareStatement(sql);
			objPStmt.setString(1, uId);
			objRs = objPStmt.executeQuery();

			while (objRs.next()) {
				GoodsQnABean qna = new GoodsQnABean();
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
