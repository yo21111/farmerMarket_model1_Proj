package pack_Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import pack_DBCP.DBConnectionMgr;
import pack_MyPage.GoodsCommentsBean;

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
				gBean.setGoodsImg(rs.getString("goodsImg"));
				gBean.setGoodsCode(rs.getString("goodsCode"));
				gBean.setGoodsPrice(rs.getInt("goodsPrice"));
				gBean.setGoodsName(rs.getString("goodsName"));
				gBean.setGoodsCatch(rs.getString("goodsCatch"));
				gBean.setGoodsWeight(rs.getString("goodsWeight"));
				gBean.setContentImg1(rs.getString("contentImg1"));
				gBean.setContentImg2(rs.getString("contentImg2"));
				gBean.setContentImg3(rs.getString("contentImg3"));
				gBean.setEventRate(rs.getInt("eventRate"));
				gBean.setDeliType(rs.getString("deliType"));
				gBean.setUnitType(rs.getString("unitType"));
				gBean.setPackType(rs.getString("packType"));

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

	// 상품 문의 게시판 내용 insert 메서드
	public boolean insertGoodsQnA(HttpServletRequest req, String uId) {
		boolean flag = false;
		String saveDir = "D:/infoProc_1119/Project/farmerMarket/proj_farmerMarket/WebContent/fileUpload";

		int maxPostSize = 10 * 1024 * 1024; // 10*1kb 1024면 10mb

		try {

			MultipartRequest mReq = new MultipartRequest(req, // request
					saveDir, // 업로드할 폴더 경로
					maxPostSize, // 업로드 허용 용량(단위 : byte)
					"UTF-8", // 인코딩
					new DefaultFileRenamePolicy() // 동일파일명 정책을 관리하는 객체
			);

			String goodsCode = mReq.getParameter("goodsCode");
			String title = mReq.getParameter("title");
			String content = mReq.getParameter("content");
			String fileName = "";
			String original = "";
			Enumeration files = mReq.getFileNames();

			while (files.hasMoreElements()) {
				String name = (String) files.nextElement();
				fileName = mReq.getFilesystemName(name);
				original = mReq.getOriginalFileName(name);
			}

			conn = pool.getConnection();

			if (fileName == null || original == null) {
				sql = "insert into goodsQnA (uId, goodsCode, title_q, contetns_q, writeTime_q)"
						+ " values(?,?,?,?,now())";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, uId);
				pstmt.setString(2, goodsCode);
				pstmt.setString(3, title);
				pstmt.setString(4, content);
			} else {
				sql = "insert into goodsQnA (uId, goodsCode, title_q, contetns_q, writeTime_q, fileOName_q, fileRName_q)"
						+ " values(?,?,?,?,now(), ? , ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, uId);
				pstmt.setString(2, goodsCode);
				pstmt.setString(3, title);
				pstmt.setString(4, content);
				pstmt.setString(5, fileName);
				pstmt.setString(6, original);
			}

			if (pstmt.executeUpdate() == 1)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt);
		}

		return flag;
	}

	// 상품 후기 게시판 내용 insert 메서드
	public boolean insertGoodsComments(HttpServletRequest req, String uId) {
		boolean flag = false;
		String saveDir = "D:/infoProc_1119/Project/farmerMarket/proj_farmerMarket/WebContent/fileUpload";

		int maxPostSize = 10 * 1024 * 1024; // 10*1kb 1024면 10mb

		try {

			MultipartRequest mReq = new MultipartRequest(req, // request
					saveDir, // 업로드할 폴더 경로
					maxPostSize, // 업로드 허용 용량(단위 : byte)
					"UTF-8", // 인코딩
					new DefaultFileRenamePolicy() // 동일파일명 정책을 관리하는 객체
			);

			String goodsCode = mReq.getParameter("goodsCode");
			String title = mReq.getParameter("title");
			String content = mReq.getParameter("content");
			String fileName = "";
			String original = "";

			Enumeration files = mReq.getFileNames();

			while (files.hasMoreElements()) {
				String name = (String) files.nextElement();
				fileName = mReq.getFilesystemName(name);
				original = mReq.getOriginalFileName(name);
			}

			conn = pool.getConnection();

			if (fileName == null || original == null) {
				sql = "insert into goodsComments (uId, goodsCode, title_c, contetns_c, writeTime_c)"
						+ " values(?,?,?,?,now())";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, uId);
				pstmt.setString(2, goodsCode);
				pstmt.setString(3, title);
				pstmt.setString(4, content);
			} else {
				sql = "insert into goodsComments (uId, goodsCode, title_c, contetns_c, writeTime_c, fileOName_c, fileRName_c)"
						+ " values(?,?,?,?,now(), ? , ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, uId);
				pstmt.setString(2, goodsCode);
				pstmt.setString(3, title);
				pstmt.setString(4, content);
				pstmt.setString(5, fileName);
				pstmt.setString(6, original);
			}

			if (pstmt.executeUpdate() == 1)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt);
		}

		return flag;
	}
	
	// 후기게시판 보여주기 메서드
	public List<GoodsCommentsBean> selectGoodsCmtList(String goodsCode) {
		List<GoodsCommentsBean> list = new ArrayList<>();

		try {
			conn = pool.getConnection();

			sql = "select * from goodsComments where goodsCode=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goodsCode);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				GoodsCommentsBean gBean = new GoodsCommentsBean();
				gBean.setNo(rs.getInt("no"));
				gBean.setuId(rs.getString("uId"));
				gBean.setGoodsCode(rs.getString("goodsCode"));
				gBean.setTitle_c(rs.getString("title_c"));
				gBean.setContetns_c(rs.getString("contetns_c"));
				gBean.setFileRName_c(rs.getString("fileRName_c"));
				gBean.setWriteTime_c(rs.getString("writeTime_c"));
				gBean.setView_cnt_c(rs.getInt("view_cnt_c"));

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
