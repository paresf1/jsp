<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
<style>
   .navbar-inverse2{
      background-color : white;
   }   
   
   #searchbar{
      width : auto;
      height : 50px;
   }
   
   #searchBtn{
      margin-top : 5px;
      height : 50px;
      width : 100px;
      border : 4px solid #779af5;
      background-color : #779af5;
      font-size : 1.5em;
      color : white;
      float:left;
   }
   
   #selectSearch{
      font-size : 1.2em;
      width: 100px;
      margin-left : 20px;
      margin-top : 5px;
      height : 50px;
      border : 4px solid #779af5;
      float:left;
   }
   
   #search{
      font-size : 1.2em;
      margin-top : 5px;
      width : 550px;
      border : 4px solid #779af5;
      padding : 10px;
      outline : none;
      height : 50px;
      float:left;
   }
   
   #div1{
      margin : 0 auto;
      width : 780px;
      height : 60px;
      border-radius: 15px;
      background-color : #779af5;
   }
   
   h3{
      text-align : center;
   }
      
   
</style>
<script>
   $(function(){
      $('#searchBtn').on('click',function(){
         if($('#search').val()==''){
            alert('검색 내용은 필수로 입력해야합니다.');
         }
      })
   })
</script>
</head>
<body>
<nav class="navbar navbar-inverse2">
    <div id="searchbar">
       <form id="form1" action="<%= request.getContextPath() %>/SearchResult" method="post">
       <div id="div1">
       <select id="selectSearch" name="selectSearch">
          <option value="company">기업명</option>
          <option value="title">제목/내용</option>
       </select>
       <input id="search" name="search" type="text" value="" placeholder="검색어를 입력해주세요">
       <input type="submit" id="searchBtn" value="검색">
       </div>
       </form>
    </div>
</nav>  

</body>
