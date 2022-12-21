const visitNum = (num) => {
    if (num >= 1e3 && num < 1e4) {
        return (num / 1e3).toFixed(1) + 'k';
    } else if (num >= 1e4 && num < 1e7) {
        return (num / 1e4).toFixed(1) + 'w';
    } else if (num >= 1e7) {
        return (num / 1e7).toFixed(1) + 'kw';
    }
    return num;
}

export default visitNum;
