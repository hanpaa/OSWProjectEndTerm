import Vue from "vue";
import VueRouter from"vue-router"
import Todo from "./views/Todo";
import isDone from "@/views/isDone";
import Home from "@/views/Home";
import createpost from "@/views/createpost";

Vue.use(VueRouter);

//URL변경시 감지 하고 해당 컴포넌트로 이동.
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
        },
        {
            path: '/createpost',
            name: 'createpost',
            component: createpost // eslint-disable-line no-unused-vars

        },
        {
            path: '/service',
            name: 'service',
            component: () => import('./views/service.vue') // eslint-disable-line no-unused-vars

        },
        {
            path: '/',
            name: 'Home',
            component: Home
        },
        {
            path: '/about',
            name: 'About',
            // route level code-splitting
            // this generates a separate chunk (about.[hash].js) for this route
            // which is lazy-loaded when the route is visited.
            component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
        }
    ]
});

export default router;
