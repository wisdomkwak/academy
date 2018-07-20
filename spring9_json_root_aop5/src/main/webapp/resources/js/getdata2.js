$(function(){
   
   $('#output').empty();
   
    // 데이터를 보여주는 함수
    function selectData(url, senddata) {
       
       var data = $('#insert_form').serialize();
       
       // Ajax를 수행합니다.
       $.ajax({url : url,
                data: senddata,
                dataType : "json",
                cache:false,
                headers : {"cache-control":"no-cache","pragma":"no-cache"},
                success : function (responsedata) {
                         $(responsedata).each(function (index, item) {
                         var output = '';
                         output += '<tr><td>' + item.id + '</td>';
                         output += '<td>' + item.name + '</td>';
                         output += '<td>' + item.modelnumber + '</td>';
                         output += '<td>' + item.series + '</td></tr>';
                         $('#output').append(output);
                         });//each end
                         }, //success end
                error : function(data){
                   alert("오류 발생");
                }//error end
       });//ajax end
    }; //function selectData end

    selectData('./jsontest3', null);
    
    // 데이터를 추가합니다.
    $('#insert_form').submit(function (event) {
       
       if ($('#name').val() == "") {
          alert('상품명을 입력하세요.');
          $('#name').focus();
          return false;
       }
       if ($('#modelNum').val() == "") {
          alert('모델번호를 입력하세요.');
          $('#modelNum').focus();
          return false;
       }
       if ($(' #series').val() == "") {
          alert('시리즈를 입력하세요.');
          $('#series').focus();
          return false;
       }
       
       //전송할 데이터들을 직렬화 합니다.
       //입력 양식에 입력한 데이터를 쿼리 스트링으로 바꿉니다.
       //name ="  "&modelnumber="  "&series="  "
       var senddata = $(this).serialize();
       selectData('./jsontest2', senddata);
       
       // 기본 이벤트를 제거합니다.
       event.preventDefault();
    });//submit end
    
 });