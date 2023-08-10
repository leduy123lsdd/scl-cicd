package com.scl

import com.cloudbees.groovy.cps.NonCPS

class PodTemplates {

    String yaml
    def projectName
    def envName

    PodTemplates(projectName = "", envName = "") {
        this.projectName = projectName
        this.envName = envName
        this.yaml = """
---
apiVersion: v1
kind: Pod
spec:
  containers:
"""
    }

    PodTemplates addKaniko() {
        this.yaml += """
  - name: kaniko
    image: gcr.io/kaniko-project/executor:v1.5.1-debug
    tty: true
    command:
    - /busybox/cat
    resources:
      requests:
        cpu: 100m
        memory: 500Mi
"""
        return this
    }

    PodTemplates addGcloud() {
        this.yaml += """
  - name: gcloud
    image: profiletechnology/gcloud-kubectl
    tty: true
    command:
    - /bin/bash
    resources:
      requests:
        cpu: 100m
        memory: 500Mi
"""
        return this
    }


    @NonCPS
    String toString() {
        return this.yaml
    }
}
