function fibonacci(n){

    if(n <= 1) return n

    let seq = [0,1]

    for(i = 0; i < n; i++) {
        seq.push(seq[seq.length - 1] + seq[seq.length - 2])
    }
    return seq[n]
}

module.exports = fibonacci