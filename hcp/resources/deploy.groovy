#!/usr/bin/env groovy
@Library('hcp_pipeline_library') _

def deploy2(def openshift, def globalVars, def stageVars, String serviceName, String stage, String project, String image) {

  openshift.apply(openshift.process(readFile("hcp/resources/inventory.yaml"),
      "SERVICE_NAME=${serviceName}",
      "PROJECT=${project}",
      "STAGE=${stage}",
      "BASE_URL=${globalVars.base_url}",
      "APPLICATION_PATH=${globalVars.application_base}/${serviceName}",
      "REPLICAS=${stageVars.replicas}",
      "IMAGE=${image}",
      "QUARKUS_PROFILE=${stage}"
  ))
}

return this