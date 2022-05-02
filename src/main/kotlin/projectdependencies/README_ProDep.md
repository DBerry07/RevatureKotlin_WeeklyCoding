# Revature Weekly Coding Exercise: 18 April 2022
## Build Order
Revature Bench weekly coding challenge for 18 April, 2022.
<br>
### Exercise Outline
You are given a list of projects and a list of 
dependencies (which is a list of pairs of projects). 
<br>The <b><i>second</b></i> project is dependent on the 
<b><i>first</b></i> project.
<br>All of a project's dependencies must be built before the project is. 
<br>Find a build order that will allow the projects to be built. 
<br>If there is no valid build order, return an error.

#### Example:
Input: <br>
<code>projects: a, b, c, d, e, f
<br>dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
</code>
Output: 
<code>f, e, a, b, d, c
</code>