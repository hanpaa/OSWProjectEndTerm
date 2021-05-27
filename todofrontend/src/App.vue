<template>
  <div id="app">
    <Header/>
    <Banner/>
    <article class="list">
      <div class="list-area">
        <div class="todo-list-sort">
          <div class="sort-method">
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

