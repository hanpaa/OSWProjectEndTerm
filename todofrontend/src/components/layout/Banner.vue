<template>
    <div class="clock" v-if="hourtime != ''">
        <div class="banner-area">
            <span class="time js-time" v-text="hourtime"></span>
            <span v-text="hours"></span>
            <div class="time js-time" v-text="minutes"></div>
            <div class="time js-time" v-text="seconds"></div>
        </div>
    </div>
</template>

<script>
    import { SECOND, HOUR, getHourTime, getZeroPad } from './Filters';
    export default {
        data() {
            return {
                hours: 0,
                minutes: 0,
                seconds: 0,
                hourtime: '',
            };
        },
        mounted() {
            const timer = window.setTimeout(this.updateDateTime, SECOND);
            this.$on('hook:destroyed', () => window.clearTimeout(timer))
        },
        methods: {
            updateDateTime() {
                const now = new Date();
                this.hours = now.getHours();
                this.minutes = getZeroPad(now.getMinutes());
                this.seconds = getZeroPad(now.getSeconds());
                this.hourtime = getHourTime(this.hours);
                this.hours = this.hours % HOUR || HOUR;
                this.$options.timer = window.setTimeout(this.updateDateTime, SECOND);
            },
        },
    };
</script>


<style scoped>

</style>
