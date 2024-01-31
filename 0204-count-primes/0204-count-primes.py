class Solution:
    def countPrimes(self, n: int) -> int:
        """Find all primes less than n."""
        prime = [True for _ in range(n+1)]
        p = 2  # First prime number is 2

        while p * p <= n:
            # If prime[p] is not changed, then it is a prime
            if prime[p]:
                # Update all multiples of p
                for i in range(p * p, n + 1, p):
                    prime[i] = False
            p += 1  # Move to the next number

        # Count prime numbers
        prime_count = sum(1 for i in range(2, n) if prime[i])
        return prime_count
