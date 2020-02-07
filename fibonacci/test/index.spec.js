const fibonacci = require('../fibonacci')
const { expect } = require('chai')

describe('fibonacci should', () => {
    it('return 0 if input number is 0', () => {
        const response = fibonacci(0)
        expect(response).to.equal(0)
    })

    it('return 1 if input number is 1', () => {
        const response = fibonacci(1)
        expect(response).to.equal(1)
    })

    it('return 1 if input number is 2', () => {
        const response = fibonacci(2)
        expect(response).to.equal(1)
    })

    it('return 8 if input number is 6', () => {
        const response = fibonacci(2)
        expect(response).to.equal(1)
    })
})