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
            updateDateTime() {
                var cd = new Date();
                this.time = zeroPadding(cd.getHours(), 2) + ':' + zeroPadding(cd.getMinutes(), 2);
                this.date = zeroPadding(cd.getFullYear(), 4) + '년 ' + zeroPadding(cd.getMonth()+1, 2) + '월 ' + zeroPadding(cd.getDate(), 2) + '일 ' + week[cd.getDay()];
                this.$options.timer = window.setTimeout(this.updateDateTime, SECOND);
            },
        },
    };
</script>


<style scoped>

</style>
