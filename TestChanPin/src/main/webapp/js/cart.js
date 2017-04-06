/**
 * Created by Administrator on 2016/9/22.
 */
window.onload=function(){
    checkBox();
    animate();
   // zhanglong();
    	
};
var checkBox=function(){
    var checkBoxList=document.getElementsByClassName('jd_check_box');
    var selectAll=document.getElementsByClassName('select_all')[0];
    var off=true;
    for(var i=0;i<checkBoxList.length;i++){
        checkBoxList[i].onclick=function(){
            var hasChecked=this.getAttribute('checked');
            if(hasChecked!==null){
                this.removeAttribute('checked');
            }else{
                this.setAttribute('checked','');
            }
        };
    }
    selectAll.addEventListener('click',function(){
        if(off){
            for(i=0;i<checkBoxList.length;i++){
                checkBoxList[i].setAttribute('checked','');
            }
            off=false;
        }else {
            for( i=0;i<checkBoxList.length;i++){
                checkBoxList[i].removeAttribute('checked');
                off=true;
            }
        }
    });
};

function animate(){
    var aDelete= document.getElementsByClassName('delete');
    var oCancel=document.getElementsByClassName('cancel')[0];
    var oSure=document.getElementsByClassName('sure')[0];
    var oMask=document.getElementsByClassName('jd_mask')[0];
    var oMaskBox=oMask.getElementsByClassName('mask_box')[0];
    var oCheck=document.getElementsByClassName('con_check');
    var oProduct=document.getElementsByClassName('con_product');
    var num=0;
    for(var i=0;i<aDelete.length;i++){
        aDelete[i].index=i;
        aDelete[i].onclick=function(){
            num=this.index;
            oMask.style.display='block';
            oMaskBox.className='mask_box jumpOut';
        };
    }

    oCancel.onclick=function(){
        oMask.style.display='none';
    };
    oSure.onclick=function(){
        oCheck[num].style.display='none';
        oProduct[num].style.display='none';
        oMask.style.display='none';

    }
    //点击加-
   
}
 var add=function (){
    	var count=document.getElementById("count");
    	var valueCount=count.getAttribute("value");
    	var countInt=parseInt(valueCount);
    	var countadd=countInt+1;
    	document.getElementById("count").value=countadd;
    	count.setAttribute("value",countadd);
    	
    };
    
 var sub=function (){
    	var count=document.getElementById("count");
    	var valueCount=count.getAttribute("value");
    	var countInt=parseInt(valueCount);
    	var countadd=countInt-1;
    	if(countadd>=1){
    		document.getElementById("count").value=countadd;
    		count.setAttribute("value",countadd);
    	}
    	
    	
    };
    $(document).ready(function(){
    	//
    	$(".right").click(function(){
			var count = parseInt($("#count").val());
			count++;
			$("#count").val(count);
		 });
		 $(".left").click(function(){
			var count = parseInt($("#count").val());
			if(count>0){
				count--;
			}
			$("#count").val(count);
		 });
    });
