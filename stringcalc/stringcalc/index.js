function stringCalculator(str){
    if (str === '') return 0
    // if (str.startsWith('-')) return `negatives not allowed: ${str}`
    const negatives = str.match(/-\d/g)
    if(negatives) return `negatives not allowed: ${negatives.join('')}`
    if (str.startsWith('//')) {
        let delimiter = str[2]
        str = str.slice(4).replace(delimiter, ',')
    }
    const numbers = str.replace(/\n/g, ",").split(",")
    return numbers.reduce((accumulator, current) => accumulator + Number(current), 0)
}

module.exports = stringCalculator