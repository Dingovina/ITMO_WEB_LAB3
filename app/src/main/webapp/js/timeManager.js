export class TimeManager {
    static dateTimeFromMilliseconds(ms) {
        return new Date(ms).toLocaleString();
    }

    static GMTdateTimeFromMilliseconds(ms) {
        const date = new Date(ms);
        const dayName = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"][date.getDay()];
        const day = date.getDate();
        const month = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"][date.getMonth()];
        const year = date.getFullYear();
        const hour = date.getHours();
        const minute = date.getMinutes();
        const second = date.getSeconds();
        return `${dayName}, ${day} ${month} ${year} ${hour}:${minute < 10 ? '0' + minute : minute}:${second < 10 ? '0' + second : second} GMT`;
    }
    
    static timePassedFromNanoseconds(ns) {
        return `${ns / 100000} ms`;
    }
}