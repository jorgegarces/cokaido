const leaps = require('../leaps')
const { expect } = require('chai')

describe('leap years', () => {
    it('should mark year 8 as a leap year', () => {
        const response = leaps(8)
        expect(response).to.equal(true)
    })

    it('should mark year 1996 as a leap year', () => {
        const response = leaps(1996)
        expect(response).to.equal(true)
    })

    it('should mark year 4 as a leap year', () => {
        const response = leaps(4)
        expect(response).to.equal(true)
    })

    it('should mark year 1 as a common year', () => {
        const response = leaps(1)
        expect(response).to.equal(false)
    })

    it('should mark year 2 as a common year', () => {
        const response = leaps(2)
        expect(response).to.equal(false)
    })

    it('should mark year 3 as a common year', () => {
        const response = leaps(3)
        expect(response).to.equal(false)
    })

    it('should mark year 2100 as common', () => {
        const response = leaps(2100)
        expect(response).to.equal(false)
    })

    it('should mark year 2200 as common', () => {
        const response = leaps(2200)
        expect(response).to.equal(false)
    })

    it('should mark year 2300 as common', () => {
        const response = leaps(2300)
        expect(response).to.equal(false)
    })

    it('should mark year 2000 as atypical leap', () => {
        const response = leaps(2000)
        expect(response).to.equal(true)
    })
    
    it('should mark year 2400 as atypical leap', () => {
        const response = leaps(2400)
        expect(response).to.equal(true)
    })

    it('should mark year 2800 as atypical leap', () => {
        const response = leaps(2800)
        expect(response).to.equal(true)
    })

    it('should mark year 3200 as atypical leap', () => {
        const response = leaps(3200)
        expect(response).to.equal(true)
    })
})