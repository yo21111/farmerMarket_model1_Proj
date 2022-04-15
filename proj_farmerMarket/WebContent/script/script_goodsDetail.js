/**
 * 
 */

$(function() {


	// 새로고침시 가장 위로 이동
	/*window.onbeforeunload = function() {
		window.scrollTo(0, 0);
	}*/


	////////////////////////////////////////////////////////////////////////////
	//////////////////////////// 수정한 내용 시작 ////////////////////////////////
	////////////////////////////////////////////////////////////////////////////

	// 구매수량 버튼 조절
	$("#cntPlus").click(function() {
		if (parseInt($(".cntBtn>input").val()) < 99) {
			let cnt = parseInt($(".cntBtn>input").val()) + 1;
			$(".cntBtn>input").val(cnt);

			let price = parseInt($("td.goods_price").text().replace(/,/g, ''));
			$("span.goods_price").text((price * cnt).toLocaleString());
		}
	});

	$("#cntMinus").click(function() {
		if (parseInt($(".cntBtn>input").val()) > 1) {
			let cnt = parseInt($(".cntBtn>input").val()) - 1;
			$(".cntBtn>input").val(cnt);

			let price = parseInt($("td.goods_price").text().replace(/,/g, ''));
			$("span.goods_price").text((price * cnt).toLocaleString());
		}
	});
	////////////////////////////////////////////////////////////////////////////
	//////////////////////////// 수정한 내용 끝 ////////////////////////////////
	////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////
	//////////////////////////// 추가한 내용 시작 ////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	
	// 천단위 기호 붙여주기 - td.goods_price
	$("td.goods_price").each(function(i, v) {
		let price = parseInt($("td.goods_price").text());
		price = price.toLocaleString();
		$(this).text(price);
	});

	// 천단위 기호 붙여주기 - span.goods_price
	$("span.goods_price").each(function(i, v) {
		let price = parseInt($("td#totalPrice input").val());
		price = price.toLocaleString();
		$(this).text(price);
	});



	/* ---------------------- goodsQna 시작 ---------------------- */

	// 문의하기 버튼 클릭
	$("button#goodsQna").click(function() {
		let position = $("td#goodsComment").prop("data-position") - 40;
		$("div#goodsQna .popup").css({ "top": "position" });
		$("div#goodsQna div.dimmed").css({ "display": "inline-block" });


	});

	//문의하기 취소버튼 클릭
	$("div#goodsQna button#cancelBtn").click(function() {
		$("div#goodsQna div.dimmed").css({ "display": "none" });
	});

	//문의하기 등록 버튼 클릭
	$("div#goodsQna button#registerBtn").click(function() {
		let goodsCode = $("td#hiddenTd input", opener).val();
		$("div#goodsQna input#goodsCode").val(goodsCode);
		// 업로드 파일 제한 (확장자를 사용하여 제한)
		let fName = $("#fName").val();

		//lastIndexOf() : 오른쪽부터 세어서 "."의 인덱스 번호 찾기
		let dotIdx = fName.lastIndexOf(".");

		// ext : extension, 확장자
		let ext = fName.substring(dotIdx + 1);
		// .의 위치 다음부터 마지막 인덱스까지 문자열 자르기

		ext = ext.toLowerCase(); //소문자로 변환

		const forbidExt = ["exe", "cab", "dll", "js"]; //이외 원하는 확장자 계속 추가
		let chk = false;
		//for-Of : 변수가 인덱스 번호의 값을 반환
		for (let x of forbidExt) { //for-in 구문 : 변수가 인덱스 번호 반환
			if (x == ext) {
				chk = true;
			}
		}

		if (chk) {
			alert("확장자가 " + ext + "인 파일은 업로드 하실 수 없습니다.");
		} else {
			//유효성 검사 통과시 submit
			$("form#goodsQnaFrm").submit();
		}
	});
	/* ---------------------- goodsQna 끝 ---------------------- */

	/* ---------------------- commentPage 시작 ---------------------- */
	// 후기 등록하기 버튼 클릭
	$("button#reviewBtn").click(function() {
		let position = $("table#review").prop("data-position") - 40;
		$("div#commentPage div.dimmed").css({ "display": "inline-block" });
		$("div#commentPage .popup").css({ "top": "position" });


	});

	//후기등록하기 취소버튼 클릭
	$("div#commentPage button#cancelBtn").click(function() {
		$("div#commentPage div.dimmed").css({ "display": "none" });
	});

	//후기 등록 버튼 클릭
	$("div#commentPage button#registerBtn").click(function() {
		let goodsCode = $("td#hiddenTd input").val();
		$("div#commentPage input#goodsCode").val(goodsCode);
		// 업로드 파일 제한 (확장자를 사용하여 제한)
		let fName = $("#fName").val();

		//lastIndexOf() : 오른쪽부터 세어서 "."의 인덱스 번호 찾기
		let dotIdx = fName.lastIndexOf(".");

		// ext : extension, 확장자
		let ext = fName.substring(dotIdx + 1);
		// .의 위치 다음부터 마지막 인덱스까지 문자열 자르기

		ext = ext.toLowerCase(); //소문자로 변환

		const forbidExt = ["exe", "cab", "dll", "js"]; //이외 원하는 확장자 계속 추가
		let chk = false;
		//for-Of : 변수가 인덱스 번호의 값을 반환
		for (let x of forbidExt) { //for-in 구문 : 변수가 인덱스 번호 반환
			if (x == ext) {
				chk = true;
			}
		}

		if (chk) {
			alert("확장자가 " + ext + "인 파일은 업로드 하실 수 없습니다.");
		} else {
			//유효성 검사 통과시 submit
			$("form#goodsCommentFrm").submit();
		}
	});
	/* ---------------------- goodsComment 끝 ---------------------- */

	////////////////////////////////////////////////////////////////////////////
	//////////////////////////// 추가한 내용 끝 /////////////////////////////////
	////////////////////////////////////////////////////////////////////////////



	// 퀵메뉴 선택시 이동 기능
	$("#quickmenu li:first-child").click(function() {
		// 절대위치 계산
		const divId = document.getElementById('goods_contents');
		const clientRect = divId.getBoundingClientRect();
		const relativeTop = clientRect.top;

		const scrolledTopLength = window.pageYOffset
		const absoluteTop = scrolledTopLength + relativeTop;
		//alert(absoluteTop);
		// 이동효과
		window.scrollTo({
			left: 0,
			top: absoluteTop - 30,
			behavior: 'smooth'
		});
		// 선택시 css 변경
		$("#quickmenu li:first-child").css({
			"background-color": "#fff",
			"border-bottom": "none",
			"color": "#741880"
		});
		$("#quickmenu li:not(:first-child)").css({
			"background-color": "#fafafa",
			"border": "1px solid #eee",
			"color": "rgba(102,102,102)"
		});
	});

	$("#quickmenu li:nth-child(2)").click(function() {
		const divId = document.getElementById('topCen');
		const clientRect = divId.getBoundingClientRect();
		const relativeTop = clientRect.top;

		const scrolledTopLength = window.pageYOffset;
		const absoluteTop = scrolledTopLength + relativeTop;
		//alert(absoluteTop);
		window.scrollTo({
			left: 0,
			top: absoluteTop - 30,
			behavior: 'smooth'
		});
		$("#quickmenu li:nth-child(2)").css({
			"background-color": "#fff",
			"border-bottom": "none",
			"color": "#741880"
		});
		$("#quickmenu li:not(:nth-child(2))").css({
			"background-color": "#fafafa",
			"border": "1px solid #eee",
			"color": "rgba(102,102,102)"
		});
	});

	$("#quickmenu li:nth-child(3)").click(function() {
		const divId = document.getElementById('topRev');
		const clientRect = divId.getBoundingClientRect();
		const relativeTop = clientRect.top;

		const scrolledTopLength = window.pageYOffset
		const absoluteTop = scrolledTopLength + relativeTop;
		//alert(absoluteTop);
		window.scrollTo({
			left: 0,
			top: absoluteTop + 30,
			behavior: 'smooth'
		});

		$("#quickmenu li:nth-child(3)").css({
			"background-color": "#fff",
			"border-bottom": "none",
			"color": "#741880"
		});
		$("#quickmenu li:not(:nth-child(3))").css({
			"background-color": "#fafafa",
			"border": "1px solid #eee",
			"color": "rgba(102,102,102)"
		});
	});

	$("#quickmenu li:nth-child(4)").click(function() {
		const divId = document.getElementById('topQna');
		const clientRect = divId.getBoundingClientRect();
		const relativeTop = clientRect.top;

		const scrolledTopLength = window.pageYOffset
		const absoluteTop = scrolledTopLength + relativeTop;
		//alert(absoluteTop);
		window.scrollTo({
			left: 0,
			top: absoluteTop - 30,
			behavior: 'smooth'
		});
		$("#quickmenu li:nth-child(4)").css({
			"background-color": "#fff",
			"border-bottom": "none",
			"color": "#741880"
		});
		$("#quickmenu li:not(:nth-child(4))").css({
			"background-color": "#fafafa",
			"border": "1px solid #eee",
			"color": "rgba(102,102,102)"
		});
	});




	// 후기게시판 펼치기
	$("#review>tbody td").click(function() {
		if ($(".hiddenRivew").css("display") == "none") {
			$(".hiddenRivew").show();
		} else {
			$(".hiddenRivew").hide();
		}
	});



	// QnA게시판 펼치기
	$("#qaTbl>tbody td").click(function() {
		if ($(".hiddenRivew").css("display") == "none") {
			$(".hiddenRivew").show();
		} else {
			$(".hiddenRivew").hide();
		}
	});



});
