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
                    <h3>할일 입력</h3>
                    <a href="#" v-on:click="closePopUp"><svg width="13" height="13" viewBox="0 0 13 13" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M11.5 1L1 11.5" stroke="#979797" stroke-width="2"/>
                        <path d="M1 1L11.5 11.5" stroke="#979797" stroke-width="2"/>
                    </svg>
                    </a>
                </div>
                <div>
                        <b-form-datepicker id="datepicker" v-model="value" class="mb-2" style="font-size: 20px"></b-form-datepicker>

                </div>
                <form class="add-todo-form">
                    <textarea name="text" rows="5" cols="10" wrap="soft" placeholder="메모" v-model="todo"></textarea>
                    <button class="add-todo-Button" type="button" v-on:click="createTodo(value, todo)">확인</button>
                </form>
            </div>
        </div>

    </div>

</template>

<script>
    import axios from "axios";

    export default {
        name: "Footer",
        data(){
            return{
                value: '',
                todo: ''
            }
        },
        methods:{
            openPopUp() {
                const popup = document.querySelector(".popup");
                setTimeout(function(){ popup.style.display = "flex"; }, 500);
            },
            closePopUp() {
                const popup = document.querySelector(".popup");
                popup.style.display = "none";
            },
            createTodo(value, todo){
                const params = new URLSearchParams();
                params.append('todo', todo);
                params.append('date', value);

                axios.post('/api/todos/' + "s85737" + '/todolist', params)
                    .then(response =>{
                        console.log(todo+"추가" + response);
                    })
                    .catch(error => console.log(error));
                this.closePopUp();

                this.$router.go();
            }
            }

        }
</script>

<style scoped>

</style>
