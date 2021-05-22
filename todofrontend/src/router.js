import Vue from "vue";
import VueRouter from"vue-router"
import Todo from "./views/Todo";

Vue.use(VueRouter);

const router = new VueRouter({
    mode: "history",
    routes: [{
        path: "/todo",
        component: Todo
    }
    //     {
    //         path: "/about",
    //         component: Home
    //     }
    ]
});

export default router;
