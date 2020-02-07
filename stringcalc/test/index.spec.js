const { expect } = require('chai')
const stringCalculator = require('../stringcalc')

describe('stringCalculator should', () => {
    it('return 0 on empty string', () => {
        const result = stringCalculator('')
        expect(result).to.equal(0)
    })

    it('return 1 when "1" is passed as an argument', () => {
        const result = stringCalculator('1')
        expect(result).to.equal(1)
    })

    it('return 2 when "2" is passed as an argument', () => {
        const result = stringCalculator('2')
        expect(result).to.equal(2)
    })

    it('return 3 when "3" is passed as an argument', () => {
        const result = stringCalculator('3')
        expect(result).to.equal(3)
    })

    it('return 3 when "1,2" is passed as an argument', () => {
        const result = stringCalculator('1,2')
        expect(result).to.equal(3)
    })

    it('return 4 when "2,2" is passed as an argument', () => {
        const result = stringCalculator('2,2')
        expect(result).to.equal(4)
    })

    it('return 5 when "3,2" is passed as an argument', () => {
        const result = stringCalculator('3,2')
        expect(result).to.equal(5)
    })
    
    it('return 6 when "1,2,3" is passed as an argument', () => {
        const result = stringCalculator('1,2,3')
        expect(result).to.equal(6)
    })

    it('return 7 when "1,2,4" is passed as an argument', () => {
        const result = stringCalculator('1,2,4')
        expect(result).to.equal(7)
    })

    it('return 8 when "1,2,5" is passed as an argument', () => {
        const result = stringCalculator('1,2,5')
        expect(result).to.equal(8)
    })
    it('return 6 when "1\n2,3" is passed as an argument', () =>{
        const result = stringCalculator('1\n2,3')
        expect(result).to.equal(6)
    })
    it ('return 7 when "1\n2,4" is passed as an argument', () => {
        const result = stringCalculator('1\n2,4')
        expect(result).to.equal(7)
    })
    it ('return 8 when "1\n2,5" is passed as an argument', () =>{
        const result = stringCalculator('1\n2,5')
        expect(result).to.equal(8)
    })
    it ('return 3 when "//;\n1;2" is passed as an argument',() =>{
        const result = stringCalculator("//;\n1;2")
        expect(result).to.equal(3)
    })
    
    it('return 4 when "//;\n2;2" is passed as an argument', () => {
        const result = stringCalculator("//;\n2;2")
        expect(result).to.equal(4)
    })

    it('return 5 when "//;\n2;3" is passed as an argument', () => {
        const result = stringCalculator("//;\n2;3")
        expect(result).to.equal(5)
    })

    it('return "negatives not allowed: -1" when "-1" is passed as an argument', () => {
        const result = stringCalculator('-1')
        expect(result).to.equal('negatives not allowed: -1')
    })

    it('return "negatives not allowed: -2" when "-2" is passed as an argument', ()=> {
        const result = stringCalculator('-2')
        expect(result).to.equal("negatives not allowed: -2")
    })

    it('return "negatives not allowed: -3" when "-3" is passed as an argument', ()=> {
        const result = stringCalculator('-3')
        expect(result).to.equal("negatives not allowed: -3")
    })

    it('return "negatives not allowed: -1-2" when "1,-1,-2" is passed as an argument', () => {
        const result = stringCalculator('1,-1,-2')
        expect(result).to.equal("negatives not allowed: -1-2")
    })

    it('return "negatives not allowed: -1-3" when "1,-1,-3" is passed as an argument', () => {
        const result = stringCalculator('1,-1,-3')
        expect(result).to.equal("negatives not allowed: -1-3")
    })

    it('return "negatives not allowed: -1-4" when "1,-1,-4" is passed as an argument', () => {
        const result = stringCalculator('1,-1,-4')
        expect(result).to.equal("negatives not allowed: -1-4")
    })

})