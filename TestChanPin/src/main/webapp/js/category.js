/**
 * Created by Administrator on 2016/9/21.
 */
window.onload=function(){
    scrollLeft();
};
var scrollLeft=function(){
    var parentBox=document.getElementsByClassName('main_left')[0];
    var childBox=parentBox.getElementsByTagName('ul')[0];
    var topbar=document.getElementsByClassName('jd_topbar')[0];
    var topH=topbar.offsetHeight;
    var height=parentBox.offsetHeight;
    var parentH=height-topH;
    var childH=childBox.offsetHeight;

    /*console.log(topH);
    console.log(height);
    console.log(parentH);
    console.log(childH);*/

    var startY=0;
    var endY=0;
    var moveY=0;
    var currY=0;

    var upDownY=150;
    var time=0;
    var startTime=0;
    var endTime=0;

    var addTransition=function(){
        childBox.style.transition="all 0.3s ease 0s";
        childBox.style.webkitTransition="all 0.3s ease 0s";
    };
    var removeTransition=function(){
        childBox.style.transition="none";
        childBox.style.webkitTransition="none";
    };
    var setTransform=function(t){
        childBox.style.transform="translateY("+t+"px)";
        childBox.style.webkitTransform="translateY("+t+"px)";
    };
    childBox.addEventListener('touchstart',function(e){
        /*console.time('tap');*/
        startTime=new Date().getTime();
        startY= e.touches[0].clientY;
    },false);
    childBox.addEventListener('touchmove',function(e){
        e.preventDefault();
        endY= e.touches[0].clientY;
        moveY=startY-endY;
        /*console.log(childH-parentH-upDownY);*/
        if(currY-moveY<upDownY&&currY-moveY>-(childH-parentH+upDownY)){
            removeTransition();
            setTransform(currY-moveY);
        }

    },false);
    childBox.addEventListener('touchend',function(e){
        /*console.timeEnd('tap');*/
        endTime=new Date().getTime();
        time=parseInt(endTime-startTime);
        /*console.log(time);*/
        if(time<150&&moveY==0){                 //li点击切换class效果
            var li= e.target.parentNode;
            var liH=li.offsetHeight;
            var aLi=li.parentNode.getElementsByTagName('li');
            /*console.log(li);*/
            /*console.log(aLi.length);*/
            for(var i=0;i<aLi.length;i++){
                aLi[i].className='';
                aLi[i].index=i;
            }
            li.className='now';
            var translateY=li.index*liH;
            console.log(translateY);


            if(translateY<childH-parentH){
                addTransition();
                setTransform(-translateY);
                currY=-translateY;
            }
        }
        if((currY-moveY)>=0){   //向上滑动吸附的情况
            addTransition();
            setTransform(0);
            currY=0;
        }
        else if((currY-moveY)<=-childH+parentH){  //向下滑动吸附的情况
            addTransition();
            setTransform(-childH+parentH);
            currY=-childH+parentH;
        }else{                              //在Ul内部滑动德情况
            currY=currY-moveY;
        }
        moveY=0;    //初始化移动距离
    },false);
};