$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/1Mock_API.feature");
formatter.feature({
  "name": "- MOCK API",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@MockAPI"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.scenario({
  "name": "Get",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@MockAPI"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@GetMock"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que faco uma requisicao GET",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "error_message": "java.lang.NullPointerException\n\tat java.util.regex.Matcher.getTextLength(Matcher.java:1283)\n\tat java.util.regex.Matcher.reset(Matcher.java:309)\n\tat java.util.regex.Matcher.\u003cinit\u003e(Matcher.java:229)\n\tat java.util.regex.Pattern.matcher(Pattern.java:1093)\n\tat com.aventstack.extentreports.utils.ExceptionUtil.getExceptionHeadline(ExceptionUtil.java:26)\n\tat com.aventstack.extentreports.ExtentTest.log(ExtentTest.java:407)\n\tat com.aventstack.extentreports.ExtentTest.skip(ExtentTest.java:971)\n\tat com.aventstack.extentreports.ExtentTest.skip(ExtentTest.java:983)\n\tat br.com.itau.friday.framework.Hooks.stepResult(Hooks.java:338)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:483)\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:63)\n\tat cucumber.runner.TestStep.run(TestStep.java:49)\n\tat cucumber.runner.PickleStepTestStep.run(PickleStepTestStep.java:46)\n\tat cucumber.runner.TestCase.run(TestCase.java:44)\n\tat cucumber.runner.Runner.runPickle(Runner.java:40)\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:124)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:65)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat cucumber.api.junit.Cucumber$1.evaluate(Cucumber.java:133)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\n",
  "status": "failed"
});
formatter.step({
  "name": "valido status response 200",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "retona status e conteudo",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Get com filtro",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@MockAPI"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@GetMockFilter"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que faco uma requisicao GET com filtro",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "error_message": "java.lang.NullPointerException\n\tat java.util.regex.Matcher.getTextLength(Matcher.java:1283)\n\tat java.util.regex.Matcher.reset(Matcher.java:309)\n\tat java.util.regex.Matcher.\u003cinit\u003e(Matcher.java:229)\n\tat java.util.regex.Pattern.matcher(Pattern.java:1093)\n\tat com.aventstack.extentreports.utils.ExceptionUtil.getExceptionHeadline(ExceptionUtil.java:26)\n\tat com.aventstack.extentreports.ExtentTest.log(ExtentTest.java:407)\n\tat com.aventstack.extentreports.ExtentTest.skip(ExtentTest.java:971)\n\tat com.aventstack.extentreports.ExtentTest.skip(ExtentTest.java:983)\n\tat br.com.itau.friday.framework.Hooks.stepResult(Hooks.java:338)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:483)\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:63)\n\tat cucumber.runner.TestStep.run(TestStep.java:49)\n\tat cucumber.runner.PickleStepTestStep.run(PickleStepTestStep.java:46)\n\tat cucumber.runner.TestCase.run(TestCase.java:44)\n\tat cucumber.runner.Runner.runPickle(Runner.java:40)\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:124)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:65)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat cucumber.api.junit.Cucumber$1.evaluate(Cucumber.java:133)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\n",
  "status": "failed"
});
formatter.step({
  "name": "valido status response 200",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "retona status e conteudo filtrado",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Post",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@MockAPI"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@PostMock"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que faco uma requisicao Post",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "error_message": "java.lang.NullPointerException\n\tat java.util.regex.Matcher.getTextLength(Matcher.java:1283)\n\tat java.util.regex.Matcher.reset(Matcher.java:309)\n\tat java.util.regex.Matcher.\u003cinit\u003e(Matcher.java:229)\n\tat java.util.regex.Pattern.matcher(Pattern.java:1093)\n\tat com.aventstack.extentreports.utils.ExceptionUtil.getExceptionHeadline(ExceptionUtil.java:26)\n\tat com.aventstack.extentreports.ExtentTest.log(ExtentTest.java:407)\n\tat com.aventstack.extentreports.ExtentTest.skip(ExtentTest.java:971)\n\tat com.aventstack.extentreports.ExtentTest.skip(ExtentTest.java:983)\n\tat br.com.itau.friday.framework.Hooks.stepResult(Hooks.java:338)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:483)\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:63)\n\tat cucumber.runner.TestStep.run(TestStep.java:49)\n\tat cucumber.runner.PickleStepTestStep.run(PickleStepTestStep.java:46)\n\tat cucumber.runner.TestCase.run(TestCase.java:44)\n\tat cucumber.runner.Runner.runPickle(Runner.java:40)\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:124)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:65)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat cucumber.api.junit.Cucumber$1.evaluate(Cucumber.java:133)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\n",
  "status": "failed"
});
formatter.step({
  "name": "valido status response 201",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "retona status e conteudo do Post",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Put",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@MockAPI"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@PutMock"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que faco uma requisicao Put",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "error_message": "java.lang.NullPointerException\n\tat java.util.regex.Matcher.getTextLength(Matcher.java:1283)\n\tat java.util.regex.Matcher.reset(Matcher.java:309)\n\tat java.util.regex.Matcher.\u003cinit\u003e(Matcher.java:229)\n\tat java.util.regex.Pattern.matcher(Pattern.java:1093)\n\tat com.aventstack.extentreports.utils.ExceptionUtil.getExceptionHeadline(ExceptionUtil.java:26)\n\tat com.aventstack.extentreports.ExtentTest.log(ExtentTest.java:407)\n\tat com.aventstack.extentreports.ExtentTest.skip(ExtentTest.java:971)\n\tat com.aventstack.extentreports.ExtentTest.skip(ExtentTest.java:983)\n\tat br.com.itau.friday.framework.Hooks.stepResult(Hooks.java:338)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:483)\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:63)\n\tat cucumber.runner.TestStep.run(TestStep.java:49)\n\tat cucumber.runner.PickleStepTestStep.run(PickleStepTestStep.java:46)\n\tat cucumber.runner.TestCase.run(TestCase.java:44)\n\tat cucumber.runner.Runner.runPickle(Runner.java:40)\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:124)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:65)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat cucumber.api.junit.Cucumber$1.evaluate(Cucumber.java:133)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\n",
  "status": "failed"
});
formatter.step({
  "name": "valido status response 200",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "retona status e conteudo do Put",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@MockAPI"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@DeleteMock"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que faco uma requisicao Delete",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "error_message": "java.lang.NullPointerException\n\tat java.util.regex.Matcher.getTextLength(Matcher.java:1283)\n\tat java.util.regex.Matcher.reset(Matcher.java:309)\n\tat java.util.regex.Matcher.\u003cinit\u003e(Matcher.java:229)\n\tat java.util.regex.Pattern.matcher(Pattern.java:1093)\n\tat com.aventstack.extentreports.utils.ExceptionUtil.getExceptionHeadline(ExceptionUtil.java:26)\n\tat com.aventstack.extentreports.ExtentTest.log(ExtentTest.java:407)\n\tat com.aventstack.extentreports.ExtentTest.skip(ExtentTest.java:971)\n\tat com.aventstack.extentreports.ExtentTest.skip(ExtentTest.java:983)\n\tat br.com.itau.friday.framework.Hooks.stepResult(Hooks.java:338)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:483)\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:63)\n\tat cucumber.runner.TestStep.run(TestStep.java:49)\n\tat cucumber.runner.PickleStepTestStep.run(PickleStepTestStep.java:46)\n\tat cucumber.runner.TestCase.run(TestCase.java:44)\n\tat cucumber.runner.Runner.runPickle(Runner.java:40)\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:124)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:65)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat cucumber.api.junit.Cucumber$1.evaluate(Cucumber.java:133)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\n",
  "status": "failed"
});
formatter.step({
  "name": "valido status response 200",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "retona status e conteudo do Delete",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("src/test/java/features/2Calc.feature");
formatter.feature({
  "name": "Testar Calc com o Winium",
  "description": "",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "name": "@DesckTop"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@winium"
    },
    {
      "name": "@closeProcess"
    }
  ]
});
formatter.scenarioOutline({
  "name": "CT-Calc - Testar calc",
  "description": "",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "name": "@CT002"
    }
  ]
});
formatter.step({
  "name": "que abro o programa \"\u003cProcess\u003e\"",
  "keyword": "Dado "
});
formatter.step({
  "name": "passo os valores",
  "keyword": "Quando "
});
formatter.step({
  "name": "resultado",
  "keyword": "Entao "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Exemplos",
  "rows": [
    {
      "cells": [
        "Process"
      ]
    },
    {
      "cells": [
        "Calculator.exe"
      ]
    }
  ]
});
formatter.background({
  "name": "Evidenciar Teste;",
  "description": "",
  "keyword": "Contexto"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "error_message": "org.openqa.selenium.WebDriverException: The driver server has unexpectedly died!\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027Air-de-Fredi\u0027, ip: \u0027192.168.15.22\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.14.6\u0027, java.version: \u00271.8.0\u0027\nDriver info: driver.version: WiniumDriver\n\tat org.openqa.selenium.winium.WiniumDriverCommandExecutor.execute(WiniumDriverCommandExecutor.java:83)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\n\tat org.openqa.selenium.remote.RemoteWebDriver.startSession(RemoteWebDriver.java:213)\n\tat org.openqa.selenium.remote.RemoteWebDriver.\u003cinit\u003e(RemoteWebDriver.java:131)\n\tat org.openqa.selenium.winium.WiniumDriver.\u003cinit\u003e(WiniumDriver.java:84)\n\tat br.com.itau.friday.framework.Hooks.openWiniumDeskop(Hooks.java:469)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:483)\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:63)\n\tat cucumber.runner.TestStep.run(TestStep.java:49)\n\tat cucumber.runner.TestCase.run(TestCase.java:40)\n\tat cucumber.runner.Runner.runPickle(Runner.java:40)\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:124)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:65)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat cucumber.api.junit.Cucumber$1.evaluate(Cucumber.java:133)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\nCaused by: java.net.ConnectException: Failed to connect to localhost/0:0:0:0:0:0:0:1:9999\n\tat okhttp3.internal.connection.RealConnection.connectSocket(RealConnection.java:247)\n\tat okhttp3.internal.connection.RealConnection.connect(RealConnection.java:165)\n\tat okhttp3.internal.connection.StreamAllocation.findConnection(StreamAllocation.java:257)\n\tat okhttp3.internal.connection.StreamAllocation.findHealthyConnection(StreamAllocation.java:135)\n\tat okhttp3.internal.connection.StreamAllocation.newStream(StreamAllocation.java:114)\n\tat okhttp3.internal.connection.ConnectInterceptor.intercept(ConnectInterceptor.java:42)\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:147)\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:121)\n\tat okhttp3.internal.cache.CacheInterceptor.intercept(CacheInterceptor.java:93)\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:147)\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:121)\n\tat okhttp3.internal.http.BridgeInterceptor.intercept(BridgeInterceptor.java:93)\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:147)\n\tat okhttp3.internal.http.RetryAndFollowUpInterceptor.intercept(RetryAndFollowUpInterceptor.java:126)\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:147)\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:121)\n\tat okhttp3.RealCall.getResponseWithInterceptorChain(RealCall.java:200)\n\tat okhttp3.RealCall.execute(RealCall.java:77)\n\tat org.openqa.selenium.remote.internal.OkHttpClient.execute(OkHttpClient.java:103)\n\tat org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:105)\n\tat org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:74)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:136)\n\tat org.openqa.selenium.winium.WiniumDriverCommandExecutor.execute(WiniumDriverCommandExecutor.java:78)\n\t... 45 more\nCaused by: java.net.ConnectException: Connection refused\n\tat java.net.PlainSocketImpl.socketConnect(Native Method)\n\tat java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:345)\n\tat java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)\n\tat java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)\n\tat java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)\n\tat java.net.Socket.connect(Socket.java:589)\n\tat okhttp3.internal.platform.Platform.connectSocket(Platform.java:129)\n\tat okhttp3.internal.connection.RealConnection.connectSocket(RealConnection.java:245)\n\t... 67 more\n",
  "status": "failed"
});
formatter.step({
  "name": "que utilizo o word para evidencias com as informacoes de execucao",
  "rows": [
    {
      "cells": [
        "Testar a calculadora com Winuim",
        "Executar uma soma simples"
      ]
    }
  ],
  "keyword": "Dado "
});
formatter.match({
  "location": "Hooks.queUtilizoWordParaEvidenciasComSeguintesInformacoes_id_nomeCT_objetivo_resultadoEsperado_resultadoObtido_Executor_SP_Cdt(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.scenario({
  "name": "CT-Calc - Testar calc",
  "description": "",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "name": "@DesckTop"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@winium"
    },
    {
      "name": "@closeProcess"
    },
    {
      "name": "@CT002"
    }
  ]
});
formatter.step({
  "name": "que abro o programa \"Calculator.exe\"",
  "keyword": "Dado "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "passo os valores",
  "keyword": "Quando "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "resultado",
  "keyword": "Entao "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("src/test/java/features/3Login.feature");
formatter.feature({
  "name": "Logar na aplicacao de cadastro de clientes da Conductor",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Logar na Aplicacao da Conductor com sucesso.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@CT001"
    },
    {
      "name": "@web"
    },
    {
      "name": "@closeBrowser"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina de login atraves da url",
  "keyword": "Given "
});
formatter.step({
  "name": "preencho o campo login \"\u003cLOGIN\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "preencho o campo password \"\u003cPASSWORD\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "clico no botao Signin",
  "keyword": "And "
});
formatter.step({
  "name": "a aplicacao exibe a mensagem \"\u003cMENSAGEM\u003e\" de bem vindo",
  "keyword": "Then "
});
formatter.step({
  "name": "clico no botao Sair",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "LOGIN",
        "PASSWORD",
        "MENSAGEM"
      ]
    },
    {
      "cells": [
        "douglasgelli@gmail.com",
        "12345678",
        "Bem vindo, Douglas Gelli!"
      ]
    },
    {
      "cells": [
        "douglasgelli@gmail.com",
        "12345678",
        "Bem vindo Douglas Gelli!"
      ]
    }
  ]
});
formatter.background({
  "name": "Evidenciar Teste;",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que utilizo o word para evidencias com as informacoes de execucao",
  "rows": [
    {
      "cells": [
        "Logar na Aplicacao da Conductor",
        "Logar na Aplicacao da Conductor com sucesso"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "Hooks.queUtilizoWordParaEvidenciasComSeguintesInformacoes_id_nomeCT_objetivo_resultadoEsperado_resultadoObtido_Executor_SP_Cdt(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "Logar na Aplicacao da Conductor com sucesso.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@CT001"
    },
    {
      "name": "@web"
    },
    {
      "name": "@closeBrowser"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina de login atraves da url",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "error_message": "java.lang.NullPointerException\n",
  "status": "failed"
});
formatter.step({
  "name": "preencho o campo login \"douglasgelli@gmail.com\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "preencho o campo password \"12345678\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "clico no botao Signin",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "a aplicacao exibe a mensagem \"Bem vindo, Douglas Gelli!\" de bem vindo",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "clico no botao Sair",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "Evidenciar Teste;",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que utilizo o word para evidencias com as informacoes de execucao",
  "rows": [
    {
      "cells": [
        "Logar na Aplicacao da Conductor",
        "Logar na Aplicacao da Conductor com sucesso"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "Hooks.queUtilizoWordParaEvidenciasComSeguintesInformacoes_id_nomeCT_objetivo_resultadoEsperado_resultadoObtido_Executor_SP_Cdt(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "Logar na Aplicacao da Conductor com sucesso.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@CT001"
    },
    {
      "name": "@web"
    },
    {
      "name": "@closeBrowser"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina de login atraves da url",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "error_message": "java.lang.NullPointerException\n",
  "status": "failed"
});
formatter.step({
  "name": "preencho o campo login \"douglasgelli@gmail.com\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "preencho o campo password \"12345678\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "clico no botao Signin",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "a aplicacao exibe a mensagem \"Bem vindo Douglas Gelli!\" de bem vindo",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "clico no botao Sair",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("src/test/java/features/3LoginChrome.feature");
formatter.feature({
  "name": "Logar na aplicacao de cadastro de clientes da Conductor",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@chrome"
    },
    {
      "name": "@closeBrowser"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Logar na Aplicacao da Conductor com sucesso com o Chrome.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@CT001"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina de login atraves da url",
  "keyword": "Given "
});
formatter.step({
  "name": "preencho o campo login \"\u003cLOGIN\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "preencho o campo password \"\u003cPASSWORD\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "clico no botao Signin",
  "keyword": "And "
});
formatter.step({
  "name": "a aplicacao exibe a mensagem \"\u003cMENSAGEM\u003e\" de bem vindo",
  "keyword": "Then "
});
formatter.step({
  "name": "clico no botao Sair",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "LOGIN",
        "PASSWORD",
        "MENSAGEM"
      ]
    },
    {
      "cells": [
        "douglasgelli@gmail.com",
        "12345678",
        "Bem vindo, Douglas Gelli!"
      ]
    },
    {
      "cells": [
        "douglasgelli@gmail.com",
        "12345678",
        "Bem vindo Douglas Gelli!"
      ]
    }
  ]
});
formatter.background({
  "name": "Evidenciar Teste;",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que utilizo o word para evidencias com as informacoes de execucao",
  "rows": [
    {
      "cells": [
        "Logar na Aplicacao da Conductor",
        "Logar na Aplicacao da Conductor com sucesso"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "Hooks.queUtilizoWordParaEvidenciasComSeguintesInformacoes_id_nomeCT_objetivo_resultadoEsperado_resultadoObtido_Executor_SP_Cdt(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "Logar na Aplicacao da Conductor com sucesso com o Chrome.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@chrome"
    },
    {
      "name": "@closeBrowser"
    },
    {
      "name": "@CT001"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina de login atraves da url",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "error_message": "java.lang.NullPointerException\n",
  "status": "failed"
});
formatter.step({
  "name": "preencho o campo login \"douglasgelli@gmail.com\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "preencho o campo password \"12345678\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "clico no botao Signin",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "a aplicacao exibe a mensagem \"Bem vindo, Douglas Gelli!\" de bem vindo",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "clico no botao Sair",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "Evidenciar Teste;",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que utilizo o word para evidencias com as informacoes de execucao",
  "rows": [
    {
      "cells": [
        "Logar na Aplicacao da Conductor",
        "Logar na Aplicacao da Conductor com sucesso"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "Hooks.queUtilizoWordParaEvidenciasComSeguintesInformacoes_id_nomeCT_objetivo_resultadoEsperado_resultadoObtido_Executor_SP_Cdt(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "Logar na Aplicacao da Conductor com sucesso com o Chrome.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@chrome"
    },
    {
      "name": "@closeBrowser"
    },
    {
      "name": "@CT001"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina de login atraves da url",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "error_message": "java.lang.NullPointerException\n",
  "status": "failed"
});
formatter.step({
  "name": "preencho o campo login \"douglasgelli@gmail.com\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "preencho o campo password \"12345678\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "clico no botao Signin",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "a aplicacao exibe a mensagem \"Bem vindo Douglas Gelli!\" de bem vindo",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "clico no botao Sair",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("src/test/java/features/3LoginEDGE.feature");
formatter.feature({
  "name": "Logar na aplicacao de cadastro de clientes da Conductor",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@edge"
    },
    {
      "name": "@closeBrowser"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Logar na Aplicacao da Conductor com sucesso com o Edge.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@CT001"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina de login atraves da url",
  "keyword": "Given "
});
formatter.step({
  "name": "preencho o campo login \"\u003cLOGIN\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "preencho o campo password \"\u003cPASSWORD\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "clico no botao Signin",
  "keyword": "And "
});
formatter.step({
  "name": "a aplicacao exibe a mensagem \"\u003cMENSAGEM\u003e\" de bem vindo",
  "keyword": "Then "
});
formatter.step({
  "name": "clico no botao Sair",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "LOGIN",
        "PASSWORD",
        "MENSAGEM"
      ]
    },
    {
      "cells": [
        "douglasgelli@gmail.com",
        "12345678",
        "Bem vindo, Douglas Gelli!"
      ]
    },
    {
      "cells": [
        "douglasgelli@gmail.com",
        "12345678",
        "Bem vindo Douglas Gelli!"
      ]
    }
  ]
});
formatter.background({
  "name": "Evidenciar Teste;",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "error_message": "org.openqa.selenium.WebDriverException: Timed out waiting for driver server to start.\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027Air-de-Fredi\u0027, ip: \u0027192.168.15.22\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.14.6\u0027, java.version: \u00271.8.0\u0027\nDriver info: driver.version: EdgeDriver\n\tat org.openqa.selenium.remote.service.DriverService.waitUntilAvailable(DriverService.java:202)\n\tat org.openqa.selenium.remote.service.DriverService.start(DriverService.java:188)\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:79)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\n\tat org.openqa.selenium.remote.RemoteWebDriver.startSession(RemoteWebDriver.java:213)\n\tat org.openqa.selenium.remote.RemoteWebDriver.\u003cinit\u003e(RemoteWebDriver.java:131)\n\tat org.openqa.selenium.edge.EdgeDriver.\u003cinit\u003e(EdgeDriver.java:141)\n\tat org.openqa.selenium.edge.EdgeDriver.\u003cinit\u003e(EdgeDriver.java:96)\n\tat br.com.itau.friday.framework.DriverFactory.startDriver(DriverFactory.java:66)\n\tat br.com.itau.friday.framework.Hooks.openEDGEBrowser(Hooks.java:416)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:483)\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:63)\n\tat cucumber.runner.TestStep.run(TestStep.java:49)\n\tat cucumber.runner.TestCase.run(TestCase.java:40)\n\tat cucumber.runner.Runner.runPickle(Runner.java:40)\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:124)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:65)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat cucumber.api.junit.Cucumber$1.evaluate(Cucumber.java:133)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\nCaused by: org.openqa.selenium.net.UrlChecker$TimeoutException: Timed out waiting for [http://localhost:11346/status] to be available after 20002 ms\n\tat org.openqa.selenium.net.UrlChecker.waitUntilAvailable(UrlChecker.java:100)\n\tat org.openqa.selenium.remote.service.DriverService.waitUntilAvailable(DriverService.java:197)\n\t... 49 more\nCaused by: java.util.concurrent.TimeoutException\n\tat java.util.concurrent.FutureTask.get(FutureTask.java:205)\n\tat com.google.common.util.concurrent.SimpleTimeLimiter.callWithTimeout(SimpleTimeLimiter.java:156)\n\tat org.openqa.selenium.net.UrlChecker.waitUntilAvailable(UrlChecker.java:75)\n\t... 50 more\n",
  "status": "failed"
});
formatter.step({
  "name": "que utilizo o word para evidencias com as informacoes de execucao",
  "rows": [
    {
      "cells": [
        "Logar na Aplicacao da Conductor",
        "Logar na Aplicacao da Conductor com sucesso"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "Hooks.queUtilizoWordParaEvidenciasComSeguintesInformacoes_id_nomeCT_objetivo_resultadoEsperado_resultadoObtido_Executor_SP_Cdt(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.scenario({
  "name": "Logar na Aplicacao da Conductor com sucesso com o Edge.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@edge"
    },
    {
      "name": "@closeBrowser"
    },
    {
      "name": "@CT001"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina de login atraves da url",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "preencho o campo login \"douglasgelli@gmail.com\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "preencho o campo password \"12345678\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "clico no botao Signin",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "a aplicacao exibe a mensagem \"Bem vindo, Douglas Gelli!\" de bem vindo",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "clico no botao Sair",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "Evidenciar Teste;",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "error_message": "org.openqa.selenium.WebDriverException: Timed out waiting for driver server to start.\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027Air-de-Fredi\u0027, ip: \u0027192.168.15.22\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.14.6\u0027, java.version: \u00271.8.0\u0027\nDriver info: driver.version: EdgeDriver\n\tat org.openqa.selenium.remote.service.DriverService.waitUntilAvailable(DriverService.java:202)\n\tat org.openqa.selenium.remote.service.DriverService.start(DriverService.java:188)\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:79)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\n\tat org.openqa.selenium.remote.RemoteWebDriver.startSession(RemoteWebDriver.java:213)\n\tat org.openqa.selenium.remote.RemoteWebDriver.\u003cinit\u003e(RemoteWebDriver.java:131)\n\tat org.openqa.selenium.edge.EdgeDriver.\u003cinit\u003e(EdgeDriver.java:141)\n\tat org.openqa.selenium.edge.EdgeDriver.\u003cinit\u003e(EdgeDriver.java:96)\n\tat br.com.itau.friday.framework.DriverFactory.startDriver(DriverFactory.java:66)\n\tat br.com.itau.friday.framework.Hooks.openEDGEBrowser(Hooks.java:416)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:483)\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:63)\n\tat cucumber.runner.TestStep.run(TestStep.java:49)\n\tat cucumber.runner.TestCase.run(TestCase.java:40)\n\tat cucumber.runner.Runner.runPickle(Runner.java:40)\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:124)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:65)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat cucumber.api.junit.Cucumber$1.evaluate(Cucumber.java:133)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\nCaused by: org.openqa.selenium.net.UrlChecker$TimeoutException: Timed out waiting for [http://localhost:21187/status] to be available after 20005 ms\n\tat org.openqa.selenium.net.UrlChecker.waitUntilAvailable(UrlChecker.java:100)\n\tat org.openqa.selenium.remote.service.DriverService.waitUntilAvailable(DriverService.java:197)\n\t... 49 more\nCaused by: java.util.concurrent.TimeoutException\n\tat java.util.concurrent.FutureTask.get(FutureTask.java:205)\n\tat com.google.common.util.concurrent.SimpleTimeLimiter.callWithTimeout(SimpleTimeLimiter.java:156)\n\tat org.openqa.selenium.net.UrlChecker.waitUntilAvailable(UrlChecker.java:75)\n\t... 50 more\n",
  "status": "failed"
});
formatter.step({
  "name": "que utilizo o word para evidencias com as informacoes de execucao",
  "rows": [
    {
      "cells": [
        "Logar na Aplicacao da Conductor",
        "Logar na Aplicacao da Conductor com sucesso"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "Hooks.queUtilizoWordParaEvidenciasComSeguintesInformacoes_id_nomeCT_objetivo_resultadoEsperado_resultadoObtido_Executor_SP_Cdt(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.scenario({
  "name": "Logar na Aplicacao da Conductor com sucesso com o Edge.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@edge"
    },
    {
      "name": "@closeBrowser"
    },
    {
      "name": "@CT001"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina de login atraves da url",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "preencho o campo login \"douglasgelli@gmail.com\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "preencho o campo password \"12345678\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "clico no botao Signin",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "a aplicacao exibe a mensagem \"Bem vindo Douglas Gelli!\" de bem vindo",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "clico no botao Sair",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("src/test/java/features/3LoginFox.feature");
formatter.feature({
  "name": "Logar na aplicacao de cadastro de clientes da Conductor",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@firefox"
    },
    {
      "name": "@closeBrowser"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Logar na Aplicacao da Conductor com sucesso com o FireFox.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@CT001"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina de login atraves da url",
  "keyword": "Given "
});
formatter.step({
  "name": "preencho o campo login \"\u003cLOGIN\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "preencho o campo password \"\u003cPASSWORD\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "clico no botao Signin",
  "keyword": "And "
});
formatter.step({
  "name": "a aplicacao exibe a mensagem \"\u003cMENSAGEM\u003e\" de bem vindo",
  "keyword": "Then "
});
formatter.step({
  "name": "clico no botao Sair",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "LOGIN",
        "PASSWORD",
        "MENSAGEM"
      ]
    },
    {
      "cells": [
        "douglasgelli@gmail.com",
        "12345678",
        "Bem vindo, Douglas Gelli!"
      ]
    },
    {
      "cells": [
        "douglasgelli@gmail.com",
        "12345678",
        "Bem vindo Douglas Gelli!"
      ]
    }
  ]
});
formatter.background({
  "name": "Evidenciar Teste;",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que utilizo o word para evidencias com as informacoes de execucao",
  "rows": [
    {
      "cells": [
        "Logar na Aplicacao da Conductor",
        "Logar na Aplicacao da Conductor com sucesso"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "Hooks.queUtilizoWordParaEvidenciasComSeguintesInformacoes_id_nomeCT_objetivo_resultadoEsperado_resultadoObtido_Executor_SP_Cdt(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "Logar na Aplicacao da Conductor com sucesso com o FireFox.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@firefox"
    },
    {
      "name": "@closeBrowser"
    },
    {
      "name": "@CT001"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina de login atraves da url",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "error_message": "java.lang.NullPointerException\n",
  "status": "failed"
});
formatter.step({
  "name": "preencho o campo login \"douglasgelli@gmail.com\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "preencho o campo password \"12345678\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "clico no botao Signin",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "a aplicacao exibe a mensagem \"Bem vindo, Douglas Gelli!\" de bem vindo",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "clico no botao Sair",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "Evidenciar Teste;",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que utilizo o word para evidencias com as informacoes de execucao",
  "rows": [
    {
      "cells": [
        "Logar na Aplicacao da Conductor",
        "Logar na Aplicacao da Conductor com sucesso"
      ]
    }
  ],
  "keyword": "Given "
});
formatter.match({
  "location": "Hooks.queUtilizoWordParaEvidenciasComSeguintesInformacoes_id_nomeCT_objetivo_resultadoEsperado_resultadoObtido_Executor_SP_Cdt(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "Logar na Aplicacao da Conductor com sucesso com o FireFox.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@firefox"
    },
    {
      "name": "@closeBrowser"
    },
    {
      "name": "@CT001"
    }
  ]
});
formatter.step({
  "name": "que estou na pagina de login atraves da url",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "error_message": "java.lang.NullPointerException\n",
  "status": "failed"
});
formatter.step({
  "name": "preencho o campo login \"douglasgelli@gmail.com\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "preencho o campo password \"12345678\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "clico no botao Signin",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "a aplicacao exibe a mensagem \"Bem vindo Douglas Gelli!\" de bem vindo",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.step({
  "name": "clico no botao Sair",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("src/test/java/features/4Mobile.feature");
formatter.feature({
  "name": "Testar Mobile",
  "description": "",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "name": "@mobile"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.background({
  "name": "Evidenciar Teste;",
  "description": "",
  "keyword": "Contexto"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "error_message": "io.appium.java_client.service.local.InvalidNodeJSInstance: Node.js is not installed!\n\tat io.appium.java_client.service.local.AppiumServiceBuilder.findDefaultExecutable(AppiumServiceBuilder.java:197)\n\tat org.openqa.selenium.remote.service.DriverService$Builder.build(DriverService.java:355)\n\tat io.appium.java_client.service.local.AppiumDriverLocalService.buildService(AppiumDriverLocalService.java:71)\n\tat br.com.itau.friday.framework.Hooks.startServer(Hooks.java:667)\n\tat br.com.itau.friday.framework.Hooks.openMobile(Hooks.java:501)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:483)\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:63)\n\tat cucumber.runner.TestStep.run(TestStep.java:49)\n\tat cucumber.runner.TestCase.run(TestCase.java:40)\n\tat cucumber.runner.Runner.runPickle(Runner.java:40)\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:124)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:65)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat cucumber.api.junit.Cucumber$1.evaluate(Cucumber.java:133)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\nCaused by: java.lang.NullPointerException: Unable to find executable for: node\n\tat com.google.common.base.Preconditions.checkNotNull(Preconditions.java:987)\n\tat org.openqa.selenium.os.OsProcess.\u003cinit\u003e(OsProcess.java:64)\n\tat org.openqa.selenium.os.CommandLine.\u003cinit\u003e(CommandLine.java:38)\n\tat io.appium.java_client.service.local.AppiumServiceBuilder.findDefaultExecutable(AppiumServiceBuilder.java:193)\n\t... 44 more\n",
  "status": "failed"
});
formatter.step({
  "name": "que utilizo o word para evidencias com as informacoes de execucao",
  "rows": [
    {
      "cells": [
        "Teste de funcionalidades",
        "todas as funções com sucessoo"
      ]
    }
  ],
  "keyword": "Dado "
});
formatter.match({
  "location": "Hooks.queUtilizoWordParaEvidenciasComSeguintesInformacoes_id_nomeCT_objetivo_resultadoEsperado_resultadoObtido_Executor_SP_Cdt(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.scenario({
  "name": "Algumas funcoes para mobile",
  "description": "",
  "keyword": "Cenario",
  "tags": [
    {
      "name": "@mobile"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@MobileCt1"
    },
    {
      "name": "@mobile"
    },
    {
      "name": "@resetMobileApp"
    }
  ]
});
formatter.step({
  "name": "que realizo algumas funcoes",
  "keyword": "Dado "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "error_message": "java.lang.NullPointerException\n\tat br.com.itau.friday.framework.Hooks.resetMobileApp(Hooks.java:540)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:483)\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:63)\n\tat cucumber.runner.TestStep.run(TestStep.java:49)\n\tat cucumber.runner.TestCase.run(TestCase.java:48)\n\tat cucumber.runner.Runner.runPickle(Runner.java:40)\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:124)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:65)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat cucumber.api.junit.Cucumber$1.evaluate(Cucumber.java:133)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "Evidenciar Teste;",
  "description": "",
  "keyword": "Contexto"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "error_message": "io.appium.java_client.service.local.InvalidNodeJSInstance: Node.js is not installed!\n\tat io.appium.java_client.service.local.AppiumServiceBuilder.findDefaultExecutable(AppiumServiceBuilder.java:197)\n\tat org.openqa.selenium.remote.service.DriverService$Builder.build(DriverService.java:355)\n\tat io.appium.java_client.service.local.AppiumDriverLocalService.buildService(AppiumDriverLocalService.java:71)\n\tat br.com.itau.friday.framework.Hooks.startServer(Hooks.java:667)\n\tat br.com.itau.friday.framework.Hooks.openMobile(Hooks.java:501)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:483)\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:63)\n\tat cucumber.runner.TestStep.run(TestStep.java:49)\n\tat cucumber.runner.TestCase.run(TestCase.java:40)\n\tat cucumber.runner.Runner.runPickle(Runner.java:40)\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:124)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:65)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat cucumber.api.junit.Cucumber$1.evaluate(Cucumber.java:133)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\nCaused by: java.lang.NullPointerException: Unable to find executable for: node\n\tat com.google.common.base.Preconditions.checkNotNull(Preconditions.java:987)\n\tat org.openqa.selenium.os.OsProcess.\u003cinit\u003e(OsProcess.java:64)\n\tat org.openqa.selenium.os.CommandLine.\u003cinit\u003e(CommandLine.java:38)\n\tat io.appium.java_client.service.local.AppiumServiceBuilder.findDefaultExecutable(AppiumServiceBuilder.java:193)\n\t... 44 more\n",
  "status": "failed"
});
formatter.step({
  "name": "que utilizo o word para evidencias com as informacoes de execucao",
  "rows": [
    {
      "cells": [
        "Teste de funcionalidades",
        "todas as funções com sucessoo"
      ]
    }
  ],
  "keyword": "Dado "
});
formatter.match({
  "location": "Hooks.queUtilizoWordParaEvidenciasComSeguintesInformacoes_id_nomeCT_objetivo_resultadoEsperado_resultadoObtido_Executor_SP_Cdt(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.scenario({
  "name": "Diversas funcoes para mobile",
  "description": "",
  "keyword": "Cenario",
  "tags": [
    {
      "name": "@mobile"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@MobileCt2"
    },
    {
      "name": "@mobile"
    },
    {
      "name": "@closeMobile"
    }
  ]
});
formatter.step({
  "name": "que abro o app e ja faz tudo",
  "keyword": "Dado "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "error_message": "java.lang.NullPointerException\n\tat br.com.itau.friday.framework.Hooks.closeMobile(Hooks.java:527)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:483)\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:63)\n\tat cucumber.runner.TestStep.run(TestStep.java:49)\n\tat cucumber.runner.TestCase.run(TestCase.java:48)\n\tat cucumber.runner.Runner.runPickle(Runner.java:40)\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:124)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:65)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\n\tat cucumber.api.junit.Cucumber$1.evaluate(Cucumber.java:133)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});