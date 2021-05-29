<template>
  <div id="app">
    <Header/>
    <Banner/>
    <article class="list">
      <div class="list-area">
        <div class="todo-list-sort">
          <div class="sort-method">
            <a id="listdefault">
              <router-link to="/todo">할일</router-link></a>
            <a>
              <router-link to="/done">했당</router-link></a>
          </div>
        </div>
        <div class="todo-list" id="listinclude">
          <router-view></router-view>
        </div>
      </div>
    </article>
    <Footer/>
  </div>
</template>

<script>


import Header from "@/components/layout/Header";
import Banner from "@/components/layout/Banner";
import Footer from "@/components/layout/Footer";
export default {
  name: 'App',
  components: {
    Footer,
    Banner,
    Header
  }
}
</script>

<style>

</style>

