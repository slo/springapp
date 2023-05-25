@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Config.class, TestConfig.class})
public class SpringTest {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private SessionService sessionService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkResultIfFeatureOn(){
        when(TestConfig.featureRepository.isFeatureOn(anyString())).thenReturn(true);
        final BigDecimal result = sessionService.calculate(new BigDecimal(7), new BigDecimal(2));
        LOGGER.debug("Result1: " + result.toPlainString());
        assertThat(result).isCloseTo(new BigDecimal(42), Offset.offset(new BigDecimal(0.01)));
    }

    @Test
    public void checkResultIfFeatureOff(){
        when(TestConfig.featureRepository.isFeatureOn(anyString())).thenReturn(false);
        final BigDecimal result = sessionService.calculate(new BigDecimal(7), new BigDecimal(2));
        LOGGER.debug("Result2: " + result.toPlainString());
        assertThat(result).isCloseTo(new BigDecimal(14), Offset.offset(new BigDecimal(0.01)));
    }

}