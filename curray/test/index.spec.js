const  {expect} = require('chai')
const Curray = require('../index')

describe('Curray should: ', ()=>{
    it('return undefined on empty curray pop', ()=>{

        const curray = new Curray()

        expect(curray.pop()).to.equal(undefined)
    })

    it('return 1 when calling pop on [1]', () => {
        const curray = new Curray()

        curray.push(1)
        
        expect(curray.pop()).to.equal(1)
    })
    
})