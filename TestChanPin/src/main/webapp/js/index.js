/**
 * Created by Administrator on 2016/9/21.
 */

window.onload=function(){
    search();
    setTime();
    sliderPic();
};

/*搜索框透明度效果*/
var search=function(){
    var search=document.getElementsByClassName('header_box')[0];
    var banner=document.getElementsByClassName('jd_banner')[0];
    var height=banner.offsetHeight;	//网页可见区域高
    window.onscroll=function(){
        var top=document.body.scrollTop;	//	网页被卷去高
        if(top>height){
            search.style.background="rgba(201,21,35,0.85)";
        }else{
            var op=top/height*0.85;
            search.style.background="rgba(201,21,35,"+op+")";
        }
    }
};
/*倒计时秒杀效果*/
var setTime=function(){
    var parentTime=document.getElementsByClassName('sk_time')[0];
    var aTime=parentTime.getElementsByClassName('num');
    var time=15*60*60;
    var h, m,s;
    var timer=null;
    changeTime();
    function changeTime(){
        h=Math.floor(time/60/60);
        m=Math.floor(time/60%60);
        s=Math.floor(time%60);
        aTime[0].innerHTML=h>10?Math.floor(h/10):0;
        aTime[1].innerHTML=h%10;

        aTime[2].innerHTML=m>10?Math.floor(m/10):0;
        aTime[3].innerHTML=m%10;

        aTime[4].innerHTML=s>10?Math.floor(s/10):0;
        aTime[5].innerHTML=s%10;
    }

        timer=setInterval(function(){
        time--;
        changeTime();
        if(time<=0){
            clearInterval(timer);
        }
    },1000)
};

/*轮播图*/
var sliderPic=function(){
    var banner=document.getElementsByClassName('jd_banner')[0];
    var width=banner.offsetWidth;
    var oUl=banner.getElementsByTagName('ul')[0];
    var oOl=banner.getElementsByTagName('ol')[0];
    var olLi=oOl.getElementsByTagName('li');
    var timer,startX=0,endX=0,moveX=0,currX=0;
    var index=1;
    /*添加过渡*/
    var addTransition=function(){
        oUl.style.transition="all 0.3s ease 0s";
        oUl.style.webkitTransition="all 0.3s ease 0s";
    };
    /*移除过渡*/
    var removeTransition=function(){
        oUl.style.transition="none";
        oUl.style.webkitTransition="none";
        moveOl(index);               //注意在移除过渡时添加圆点切换效果
    };
    /*设置动画*/
    var setTransform=function(t){
        oUl.style.transform="translateX("+t+"px)";
        oUl.style.webkitTransform="translateX("+t+"px)";
    };
    var moveOl=function(index){
        for(var i=0;i<olLi.length;i++){
            olLi[i].className='';
        }
        olLi[index-1].className='now';
    };
    timer=setInterval(function(){
        index++;
        addTransition();
        setTransform(-index*width);
    },3000);
    oUl.addEventListener('transitionEnd',function(){
        if(index>=9){
            index=1;
        }else if(index<=0){
            index=8;
        }
        removeTransition();
        setTransform(-index*width);
    });
    oUl.addEventListener('webkitTransitionEnd',function(){
        if(index>=9){
            index=1;
        }else if(index<=0){
            index=8;
        }
        removeTransition();
        setTransform(-index*width);
    });
    oUl.addEventListener('touchstart',function(e){
        /*console.log('start');*/
        startX=e.touches[0].clientX;

        /*console.log(startX);*/
    });
    banner.addEventListener('touchmove',function(e){//这里给oUl添加事件监听为什么没有效果？？？
        clearInterval(timer);
        console.log(e);
        endX= e.touches[0].clientX;
        moveX=startX-endX;
        e.preventDefault();
        removeTransition();
        setTransform(-index*width-moveX);

    });

    oUl.addEventListener('touchend',function(e){
        if(Math.abs(moveX)>(1/3*width)&&endX!=0){
            if(moveX>0){
                index++;
            }else{
                index--;
            }
            setTransform(-index*width);
        }
        addTransition();
        setTransform(-index*width);

        startX=0;
        endX=0;
        clearInterval(timer);
        timer=setInterval(function(){
            index++;
            addTransition();
            setTransform(-index*width);
        },3000);
    });




};


