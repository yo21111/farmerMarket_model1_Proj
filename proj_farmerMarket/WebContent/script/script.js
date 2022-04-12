/**
 * 
 */

/*///////////////////////////////////////////////////////////////////////////////////////////////////////////*/
/*//////////////////////////////////////////// index.jsp 시작 ///////////////////////////////////////////////*/
/*///////////////////////////////////////////////////////////////////////////////////////////////////////////*/
let slideIndex = 1;
showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
	showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
	showSlides(slideIndex = n);
}

function showSlides(n) {
	let i;
	let slides = document.getElementsByClassName("mySlides");
	let dots = document.getElementsByClassName("dot");
	if (n > slides.length) { slideIndex = 1 }
	if (n < 1) { slideIndex = slides.length; }
	for (i = 0; i < slides.length; i++) {
		slides[i].style.display = "none";
	}
	for (i = 0; i < dots.length; i++) {
		dots[i].className = dots[i].className.replace(" active", "");
	}
	slides[slideIndex - 1].style.display = "block";
	dots[slideIndex - 1].className += " active";
}
/*///////////////////////////////////////////////////////////////////////////////////////////////////////////*/
/*//////////////////////////////////////////// index.jsp 끝 ///////////////////////////////////////////////*/
/*///////////////////////////////////////////////////////////////////////////////////////////////////////////*/

$(function() {
	// infoCenter관련 시작
	$("#main #mainlnb_M>ul>li.main_MLi").click(function() {

		$("#main #mainlnb_M>ul>li.main_MLi").removeClass("selected");
		$(this).addClass("selected");

	});

	$("#main #contents table#FAQTbl .dropChk").click(function() {
		let chk = $("#main #contents table#FAQTbl tr").hasClass("False");
		$("#main #contents table#FAQTbl .False").css("display", "block");
		if (chk) {
			$("#main #contents table#FAQTbl .cheked").removeClass("False");

		}
	});

	$("#main #contents table#FAQTbl .cheked").click(function() {
		let chk = $("#main #contents table#FAQTbl tr").hasClass("False");
		if (!chk) {
		$("#main #contents table#FAQTbl .cheked").css("display", "none");
		} else if (chk) {
			//   $("#main #contents table#FAQTbl .False").css("display","none");
			//	$("#main #contents table#FAQTbl .cheked").addClass("False");

		}
	});

        $("#main #contents table#FAQTbl input#dropBtn").click(function() {
          //let chk = $(this).prop("cheked","boolean");
          // alert(type(chk));
           let chk =   $(this).prop("checked");          
             alert(chk);
          if(!chk){
	         $("#main #contents table#FAQTbl input#dropBtn").val("▲")
             
            }
         });
         

	// $("#main #contents table#FAQTbl .False").css("display","none")	

	//	alert(chk);

	// infoCenter관련 끝









});