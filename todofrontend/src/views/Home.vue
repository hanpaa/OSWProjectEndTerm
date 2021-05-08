<template>
    <div>
        <Header/>
        <Banner/>
        <Contents/>
        <Footer/>
    </div>
</template>

<script>
    import Header from "@/components/layout/Header";
    import Banner from "@/components/layout/Banner";
    import Contents from "@/components/layout/Contents";
    import Footer from "@/components/layout/Footer";
    export default {
        name: "Home",
        components: {Footer, Contents, Banner, Header},
    }
</script>

<style scoped>

</style>
