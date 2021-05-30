<template>
    <div >
        <div v-for = 'todo in todos' v-bind:key="todo.todoId">

            <!--박스반복------------------------------->
            <div class="box"  v-if="todo.isDone === 0">
                <div class="box-contents" >
                    <div class="todo">
                        <div class="todo-title">
<!--                            <img src="img/profile/verygood.jpg" alt="profile">-->
                            <h3>{{todo.date}}</h3>
                        </div>
                        <div class="todo-text" v-if="todo.priority === 0" style="color: #9F9F9F">
                            <p>천천히</p>
                            <p>{{todo.todo}}</p>
                        </div>
                        <div class="todo-text" v-if="todo.priority === 1" style="color: black">
                            <p>보통</p>
                            <p>{{todo.todo}}</p>
                        </div>
                        <div class="todo-text" v-if="todo.priority === 2" style="color: coral">
                            <p>급해</p>
                            <p>{{todo.todo}}</p>
                        </div>
                        <div class="todo-text" v-if="todo.priority === 3" style="color: red">
                            <p>빨리</p>
                            <p>{{todo.todo}}</p>
                        </div>

                    </div>
                    <div class="checkbox">
                        <form action="">
                            <input type="checkbox" v-on:click="makeDone(todo.todoId, todo.todo, todo.date, todo.priority)">
                        </form>
                    </div>
                </div>

                <div class="box-setting" v-if="todo">
                    <a v-on:click="deleteTodo(todo.todoId)">
                        <svg width="8" height="12" viewBox="0 0 8 12" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path d="M0.571429 10.6667C0.571429 11.4 1.08571 12 1.71429 12H6.28571C6.91429 12 7.42857 11.4 7.42857 10.6667V4C7.42857 3.26667 6.91429 2.66667 6.28571 2.66667H1.71429C1.08571 2.66667 0.571429 3.26667 0.571429 4V10.6667ZM7.42857 0.666667H6L5.59429 0.193333C5.49143 0.0733333 5.34286 0 5.19429 0H2.80571C2.65714 0 2.50857 0.0733333 2.40571 0.193333L2 0.666667H0.571429C0.257143 0.666667 0 0.966667 0 1.33333C0 1.7 0.257143 2 0.571429 2H7.42857C7.74286 2 8 1.7 8 1.33333C8 0.966667 7.74286 0.666667 7.42857 0.666667Z" fill="#898989"/>
                        </svg>
                    </a>
                    <a v-on:click="setPriority(todo.todoId, todo.todo, todo.date, todo.isDone, todo.priority)" >
                        <svg width="11" height="11" viewBox="0 0 11 11" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path d="M9.70743 6.03626C9.72864 5.86438 9.74279 5.68563 9.74279 5.50001C9.74279 5.31438 9.72864 5.13563 9.70036 4.96376L10.8954 4.05626C10.9467 4.0145 10.9817 3.95692 10.9945 3.89311C11.0074 3.8293 10.9974 3.76312 10.9661 3.70564L9.83471 1.80126C9.764 1.67751 9.6155 1.63626 9.48822 1.67751L8.08103 2.22751C7.78881 2.00821 7.46776 1.82786 7.1264 1.69126L6.91426 0.233767C6.90403 0.168193 6.86977 0.108421 6.8178 0.0654665C6.76582 0.0225117 6.69962 -0.000732163 6.63141 1.75875e-05H4.36859C4.30115 -0.000647838 4.2358 0.0227907 4.18496 0.0658823C4.13412 0.108974 4.10133 0.168717 4.09281 0.233767L3.88067 1.69126C3.53988 1.829 3.21898 2.00926 2.92604 2.22751L1.51885 1.67751C1.45548 1.65376 1.3854 1.65322 1.32165 1.67599C1.2579 1.69876 1.20484 1.74328 1.17236 1.80126L0.0409478 3.70564C0.00595702 3.76221 -0.00618252 3.8294 0.00688246 3.89418C0.0199474 3.95896 0.0572862 4.01672 0.111661 4.05626L1.30671 4.96376C1.27843 5.13563 1.25721 5.32126 1.25721 5.50001C1.25721 5.67876 1.27136 5.86438 1.29964 6.03626L0.10459 6.94376C0.0533201 6.98551 0.0183311 7.0431 0.00546207 7.10691C-0.00740697 7.17072 0.00262245 7.23689 0.0338765 7.29438L1.16529 9.19875C1.236 9.3225 1.3845 9.36375 1.51178 9.3225L2.91897 8.7725C3.21118 8.99181 3.53224 9.17215 3.8736 9.30875L4.08574 10.7662C4.11402 10.9037 4.22716 11 4.36859 11H6.63141C6.77284 11 6.89305 10.9037 6.90719 10.7662L7.11933 9.30875C7.46012 9.17102 7.78102 8.99076 8.07396 8.7725L9.48115 9.3225C9.60843 9.37063 9.75693 9.3225 9.82764 9.19875L10.9591 7.29438C10.994 7.23781 11.0062 7.17062 10.9931 7.10583C10.9801 7.04105 10.9427 6.98329 10.8883 6.94376L9.70743 6.03626ZM5.5 7.56251C4.33323 7.56251 3.37861 6.63438 3.37861 5.50001C3.37861 4.36564 4.33323 3.43751 5.5 3.43751C6.66677 3.43751 7.62139 4.36564 7.62139 5.50001C7.62139 6.63438 6.66677 7.56251 5.5 7.56251Z" fill="#898989"/>
                        </svg>
                    </a>
                </div>
            </div>

        </div>


    </div>

</template>

<script>
    import axios from 'axios';

    export default {
        data(){
            return{
                todos: []
            };
        },
        created(){
            this.loadTodo();
        },
        // updated(){
        //     this.loadTodo();
        // },
        methods: {
            loadTodo(){
                // this.getTodo()
                axios.get('/api/todos/' + this.$userId + '/todolist')
                    .then(response =>{
                        this.todos = response.data;
                    })
                    .catch(error => console.log(error));
            },
            deleteTodo(todoId){

                axios.delete('/api/todos/' + this.$userId + '/todolist/' + todoId)
                    .then(response =>{
                        console.log(todoId+"번 TODO 삭제" + response);
                    })
                .catch(error => console.log(error));

                setTimeout(this.loadTodo(), 100);
                setTimeout(this.loadTodo(), 100);

            },
            makeDone(todoId, todo, date, priority){

                let params = new URLSearchParams();

                let bool = '1';

                params.append('id', todoId);
                params.append('todo', todo);
                params.append('isDone', bool);
                params.append('date', date);
                params.append('priority', priority);

                axios.put('/api/todos/' + this.$userId + '/todolist/',params)
                    .then(response =>{
                    console.log(todoId+"번 TODO done." + response);
                })
                    .catch(error => console.log(error));

                setTimeout(this.loadTodo(), 100);
                setTimeout(this.loadTodo(), 100);

            },
            setPriority(todoId, todo, date, bool, priority){

                let params = new URLSearchParams();

                priority++;
                if(priority>3) priority = 0;

                params.append('id', todoId);
                params.append('todo', todo);
                params.append('isDone', bool);
                params.append('date', date);
                params.append('priority', priority);

                axios.put('/api/todos/' + this.$userId + '/todolist/',params)
                    .then(() =>{
                        console.log(todoId+"번 TODO done. set priority " + priority);
                    })
                    .catch(error => console.log(error));


                setTimeout(this.loadTodo(), 100)
                setTimeout(this.loadTodo(), 100);

            }
        }

    };
</script>



<style scoped>

</style>
