

<template>
    <!--Header-->
    <header class="header">
        <div class="header-area">
            <div class="logo">
                <h1><a href="#">MyTodo</a></h1>
            </div>

            <div class="login" v-if="this.$userId === null">
                <a href="http://osw8team.kro.kr:8081/login.jsp">Login</a>
                <a href="http://osw8team.kro.kr:8081/join.jsp">Sign up</a>
            </div>


            <div class="login" v-if="this.$userId">
                <a href="http://osw8team.kro.kr:8081/bbs.jsp" style="padding: 16px; font-size: 1.4rem; color: #b89d0e;">Board</a>
                <a href="http://osw8team.kro.kr:8081/logoutAction.jsp">Logout</a>
            </div>


        </div>

    </header>



</template>

<script>

    export default {
        name: "Header",
    }


</script>

<style>


</style>
