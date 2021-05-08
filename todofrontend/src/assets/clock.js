const clockContainer = document.querySelector(".js-time"),
    clockTitle = clockContainer.querySelector("h2"),
    dayTitle = clockContainer.querySelector("p");
function getTime() {
    const date = new Date();
    const minutes = date.getMinutes();
    const hours = date.getHours();
    const YYYY = date.getFullYear();
    const MM = date.getMonth();
    const DD = date.getDate();
    var week = new Array();
    week[0] = "일";
    week[1] = "월";
    week[2] = "화";
    week[3] = "수";
    week[4] = "목";
    week[5] = "금";
    week[6] = "토";
    const weekday = week[date.getDay()];
    clockTitle.innerText = `${hours < 10 ? `0${hours}` : hours}:${minutes < 10 ? `0${minutes}` : minutes}`;
    dayTitle.innerText = `${YYYY}년 ${MM + 1}월 ${DD}일 ${weekday}요일`;
}
function init() {
    getTime();
    setInterval(getTime, 1000);
}

init();