import Vue from "vue";
import VueRouter from"vue-router"
import Todo from "./views/Todo";
import isDone from "@/views/isDone";

Vue.use(VueRouter);

const router = new VueRouter({
    mode: "history",
    routes: [
        {
            path: "/todo",
            component: Todo
        },
        {
            path: "/done",
            component: isDone
        }
    ]
});

export default router;
