```java
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TicTacToeUnitTestSpringContextConfig.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
```