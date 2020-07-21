
function init(){
	// 船的移动
	var x = 20,y = 280;
	var yago = 280;
	var xago = 20;
	var canvasw = 1500,canvash = 700;
	var boatw = 260,boath = 200;
	var cloady = Math.random()*(canvash-300) + boath;
	var cloadx = canvasw;
	var cloadn = Math.ceil(Math.random()*4) ;
	var boatspeed = 50;
	var bgspeed =-7;
	var cloadpaint;
	var cloadstep;
	//热气球b
	var bx1 = 1390;
	var by1 = 0;
	var bx2 = 1395;
	var by2 = 330;

	//热气球a
	var ax1 = 1695;
	var ay1 = 1;
	var ax2 = 2065;
	var ay2 = 230;

	//热气球c
	var cx1 = 2420;
	var cy1 = 115;
	var cx2 = 2790;
	var cy2 = 365;

	setInterval(function(){
		bx1 = 1390;
		bx2 = 1690;
		ax1 = 1695;
		ax2 = 2065;
		cx1 = 2420;
		cx2 = 2790;
	},10000)
	//热气球的移动
	setInterval(function(){
		bx1 -= 21.2;
		bx2 -= 21.2;
		ax1 -= 21.2;
		ax2 -= 21.2;
		cx1 -= 21.2;
		cx2 -= 21.2;
		ballooncrashb()
		ballooncrasha()
		ballooncrashc()
		// console.log(bx1,bx2)
	},50)

	// setInterval(function(){
	// 	bx1 -= 424;
	// 	bx2 -= 424;
	// 	ax1 -= 424;
	// 	ax2 -= 424;
	// 	cx1 -= 424;
	// 	cx2 -= 424;
	// 	// ballooncrashb()
	// 	console.log(cx1,cx2)
	// },1000)

	var c = document.getElementById("canvas");
	var ctx= c.getContext('2d');

	var img = document.getElementById("boat");
	ctx.drawImage(img,x,y,220,180);

	document.body.onkeydown = function (evt) {
		var e = evt || event;

		switch (e.keyCode){
			case 37:
				doMove.left();
				break;
			case 38:
				doMove.up();
				break;
			case 39:
				doMove.right();
				break;
			case 40:
				doMove.down();
				break;
		}

	}

	var doMove = {
		up: function (){
			xago = x;
			yago = y;
			y -= boatspeed;
			y < 0 ? y = 0 : y ;
			drawboat()
		},down: function(){
			xago = x;
			yago = y;
			y += boatspeed;
			y > canvash - 335 ? y = canvash -335: y;
			drawboat()
		},left: function(){
			xago = x;
			yago = y;
			x -= boatspeed;
			x < 0 ? x=0: x;
			drawboat();
		},right: function(){
			xago =x;
			yago = y;
			x += boatspeed;
			x > canvasw - boatw ? x = canvasw - boatw :x;
			drawboat();
		},

	}

	function drawboat(){
		ctx.clearRect(xago,yago,boatw,boath);
		ctx.drawImage(img,x,y,220,180);
		console.log(x,y)

	}


	//计时器

	minute = document.getElementById("minute");
	second = document.getElementById("second");

	timer = null;
	minute1 = 0;
	second1 = 0;

	var time = setInterval(function(){

		second1++;
		if(second1 > 59){
			second1 = 0;
			minute1++;
		}

		if(second1 < 10){
			second.innerText = "0" +second1;
		}else{
			second.innerText = second1;
		}

		if(minute1 < 10){
			minute.innerText = "0" + minute1;
		}else{
			minute.innerText = minute1;
		}
		timer = minute1+ ":" +second1;
		if(ballooncrashb()!=1 && ballooncrasha()!=1 && ballooncrashc()!=1){
			document.getElementById("endtime").innerHTML=timer

		}else{
			clearInterval(time);
		}

	},1000)


	//撞击事件
	function ballooncrashb(){
		if(x < bx2 && x > bx1){
			if(y < by2 && y > by1){
				$("#end").fadeIn(20);
				return 1;
			}
		}
	}

	function ballooncrasha(){
		if(x < ax2 && x > ax1){
			if(y < ay2 && y > ay1){
				$("#end").fadeIn(20);
				return 1;
			}
		}
	}

	function ballooncrashc(){
		if(x < cx2 && x > cx1){
			if(y < cy2 && y > cy1){
				$("#end").fadeIn(20);
				return 1;
			}
		}
	}

}


	
	
		
		
	
	


		