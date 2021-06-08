<template>

    <div class="banner">
        <div class="banner-area">
            <div class="time js-time">
                <h2  v-text="time"/>
                <p v-text="date"></p>
            </div>
        </div>
    </div>
</template>

<script>
    import {SECOND, zeroPadding, week} from './Filters';
    export default {
        data() {
            //실질적으로 데이터들이 들어올 곳
            return {
                time: '',
                date: ''
            };
        },
        mounted() {
            const timer = window.setTimeout(this.updateDateTime, SECOND);
            this.$on('hook:destroyed', () => window.clearTimeout(timer))
        },
        methods: {

            // 시계 실시간으로 변경
            updateDateTime() {
                var cd = new Date();
                //date format 설정
                this.time = zeroPadding(cd.getHours(), 2) + ':' + zeroPadding(cd.getMinutes(), 2);
                this.date = zeroPadding(cd.getFullYear(), 4) + '년 ' + zeroPadding(cd.getMonth()+1, 2) + '월 ' + zeroPadding(cd.getDate(), 2) + '일 ' + week[cd.getDay()];
                this.$options.timer = window.setTimeout(this.updateDateTime, SECOND);
            },
        },
    };
</script>


<style scoped>

</style>
