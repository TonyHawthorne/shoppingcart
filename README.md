# Shopping Cart Exercise
### Candidate:
#### Name: Tony Hawthorne

### Step 1: Shopping Cart (Initial Assumptions)
- Assume we have received a list of items to be added to the cart along with how many of each to add.
- Assume no duplication of Items when adding to the cart - an Item will be added only once.
- Assume we don't need to check for that scenario since we have no business rule.
- Assume only valid Items will be added to the cart (ie only Apples or Oranges) so we don't need to validate that either.

### Step 2: Introduce Rules
- Buy one get one free on apples
- 3 for the price of two on oranges

### Step 2.1: Assumptions
- Cart rules are "different things that exhibit the same behavior", therefore strategy pattern is relevant.
- The cart will not apply rules to itself, rather we'll pass the cart to a rule engine which will apply rules 
- and amend the cart or cart items accordingly.
- The order that rules are applied is important but not yet defined.

### Step 2.2: Further Considerations
- It seems rules can and will overlap at some point leading to undefined results.
- We'll need to define that order ahead of time so new rules don't fall foul of what we expect.
- We'll likely need:
  - a 'discounted' flag per cart item to track if a rule was already applied.
  - to decide which rules types should be applied first (item or cart level)
  - to define the order of rule execution within those types
  - to let each rule decide how it interprets the discounted flag.
- The list goes on! We can discuss further.
