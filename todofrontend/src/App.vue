<template>
  <div id="app">
    <Header/>
    <Banner/>
    <div id="content" class="content">
      <router-view></router-view>
    </div>
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

