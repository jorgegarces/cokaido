class Curray {
    constructor(){
        this.arrayinterno = []
    }

    pop(){
        if (!this.arrayinterno.length) return undefined
        return this.last
    }

    push(element){
        this.last = element
        this.arrayinterno = [this.last]
    }
}

module.exports = Curray
