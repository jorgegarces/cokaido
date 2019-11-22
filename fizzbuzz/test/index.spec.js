const fizzbuzz = require('../fizzbuzz/index')
const { expect } = require('chai')

describe('fizzbuzz', () => {
      it('should return ¨1¨ if num is 1', () => {
        const response = fizzbuzz(1)

        expect(response).to.equal('1')
      })

      it('should return ¨2¨ if num is 2', () => {
        const response = fizzbuzz(2)

        expect(response).to.equal('2')
      })

      it('should return ¨4¨ if num is 4', () => {
        const response = fizzbuzz(4)

        expect(response).to.equal('4')
      })

      it('should return ¨7¨ if num is 7', () => {
        const response = fizzbuzz(7)

        expect(response).to.equal('7')
      })

      it('should return ¨11¨ if num is 11', () => {
        const response = fizzbuzz(11)

        expect(response).to.equal('11')
      })

      it('should return "fizz" if num is 3', () => {
        const response = fizzbuzz(3)

        expect(response).to.equal('fizz')
      })

      it('should return "fizz" if num is 6', () => {
        const response = fizzbuzz(6)

        expect(response).to.equal('fizz')
      })

      it('should return "fizz" if num is 9', () => {
        const response = fizzbuzz(9)

        expect(response).to.equal('fizz')
      })

      it('should return "buzz" if num is 5', () => {
        const response = fizzbuzz(5)

        expect(response).to.equal('buzz')
      })

      it('should return "buzz" if num is 10', () => {
        const response = fizzbuzz(10)

        expect(response).to.equal('buzz')
      })

      it('should return "buzz" if num is 20', () => {
        const response = fizzbuzz(20)

        expect(response).to.equal('buzz')
      })

      it('should return "fizzbuzz" if num is 15', () => {
        const response = fizzbuzz(15)

        expect(response).to.equal('fizzbuzz')
      })

      it('should return "fizzbuzz" if num is 45', () => {
        const response = fizzbuzz(45)

        expect(response).to.equal('fizzbuzz')
      })
      
})