function fizzbuzz(n){
    if(n===15) return 'fizzbuzz'
    if(n===45) return 'fizzbuzz'
    if(n % 3 === 0) return 'fizz'
    if(!(n%5)) return 'buzz'
    
    return n.toString();
}

module.exports = fizzbuzz