package pack_Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pack_DBCP.DBConnectionMgr;

public class GoodsDao {

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private DBConnectionMgr pool = null;
	String sql = "";

	public GoodsDao() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	// 상품 상세페이지 구현을 위해서 데이터 가져오기
	public GoodsBean selectGoodsOne(String goodsCode) {
		GoodsBean gBean = new GoodsBean();

		try {
			conn = pool.getConnection();

			sql = "select * from goods where goodsCode= ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, goodsCode);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				gBean.setGoodsImg(rs.getString("goodsImg"));;
				gBean.setGoodsCode(rs.getString("goodsCode"));;
				gBean.setGoodsPrice(rs.getInt("goodsPrice"));;
				gBean.setGoodsName(rs.getString("goodsName"));;
				gBean.setGoodsCatch(rs.getString("goodsCatch"));;
				gBean.setGoodsWeight(rs.getString("goodsWeight"));;
				gBean.setContentImg1(rs.getString("contentImg1"));;
				gBean.setContentImg2(rs.getString("contentImg2"));;
				gBean.setContentImg3(rs.getString("contentImg3"));;
				gBean.setEventRate(rs.getInt("eventRate"));;
				gBean.setDeliType(rs.getString("deliType"));;
				gBean.setUnitType(rs.getString("unitType"));;
				gBean.setPackType(rs.getString("packType"));;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt, rs);
		}

		return gBean;
	}

	
	
	// 상품코드 첫번째 글자 및 정렬기준 활용하여 메인페이지 상품 보여주기
	public List<GoodsBean> selectGoodsList(String category, String orderby) {
		List<GoodsBean> list = new ArrayList<>();

		try {
			conn = pool.getConnection();

			sql = "select goodsImg, goodsCode, goodsPrice, goodsName, goodsCatch, eventRate "
					+ "from goods where goodsCode like '" + category + "%' " + orderby + " limit 3";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				GoodsBean gBean = new GoodsBean();
				gBean.setGoodsImg(rs.getString("goodsImg"));
				gBean.setGoodsCode(rs.getString("goodsCode"));
				gBean.setGoodsPrice(rs.getInt("goodsPrice"));
				gBean.setGoodsName(rs.getString("goodsName"));
				gBean.setGoodsCatch(rs.getString("goodsCatch"));
				gBean.setEventRate(rs.getInt("eventRate"));

				list.add(gBean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt, rs);
		}

		return list;
	}
}
