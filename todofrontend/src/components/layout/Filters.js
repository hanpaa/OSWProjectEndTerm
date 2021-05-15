export const SECOND = 1000;
export const HOUR = 12;
export const week = ['일요일', '월요일', '화요일', '수요일', '목', '금요일', '토요일'];

export function zeroPadding(num, digit) {
    var zero = '';
    for(var i = 0; i < digit; i++) {
        zero += '0';
    }
    return (zero + num).slice(-digit);
}


