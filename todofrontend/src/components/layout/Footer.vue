<template>
    <div>

        <footer class="nav" id="nav">
            <div class="nav-area">
                <div class="nav-area-plus">
                    <button type="button" v-on:click="openPopUp">
                        <svg width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path d="M16 6.85714H9.14286V0H6.85714V6.85714H0V9.14286H6.85714V16H9.14286V9.14286H16V6.85714Z" fill="#D20BBE"/>
                        </svg>
                    </button>
                </div>
            </div>
        </footer>

        <div class="popup">
            <div class="add-todo">
                <div class="head">
                    <h3>Name</h3>
                    <a href="#" v-on:click="closePopUp"><svg width="13" height="13" viewBox="0 0 13 13" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M11.5 1L1 11.5" stroke="#979797" stroke-width="2"/>
                        <path d="M1 1L11.5 11.5" stroke="#979797" stroke-width="2"/>
                    </svg>
                    </a>
                </div>
                <form>
                    <textarea name="text" rows="1" cols="10" wrap="soft" placeholder="언제까지 할꺼야"></textarea>
                    <textarea name="text" rows="5" cols="10" wrap="soft" placeholder="메모"></textarea>
                    <button type="submit">확인</button>
                </form>
            </div>
        </div>

    </div>

</template>

<script>
    export default {
        name: "Footer",
        methods:{
            openPopUp: function () {
                const popup = document.querySelector(".popup");
                setTimeout(function(){ popup.style.display = "flex"; }, 500);
            },
            closePopUp: function () {
                const popup = document.querySelector(".popup");
                popup.style.display = "none";
            }
            }
        }
</script>

<style scoped>

</style>
