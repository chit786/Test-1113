// Exported from:        http://44c9647b4ea2:5516/#/templates/Release5377584/releasefile
// XL Release version:   8.1.0-rc.3
// Date created:         Thu Jun 14 13:52:34 UTC 2018

xlr {
  template('ServiceNow_Example') {
    variables {
      stringVariable('short_description') {
        
      }
      stringVariable('comment') {
        
      }
      stringVariable('ChangeTicket') {
        required false
        showOnReleaseStart false
      }
      stringVariable('taskId') {
        required false
        showOnReleaseStart false
      }
      stringVariable('TaskNumber') {
        required false
        showOnReleaseStart false
      }
      stringVariable('ChangeTask') {
        required false
        showOnReleaseStart false
      }
      stringVariable('ChangeTicke') {
        required false
        showOnReleaseStart false
      }
      stringVariable('sysId') {
        required false
        showOnReleaseStart false
      }
      stringVariable('sysId2') {
        required false
        showOnReleaseStart false
      }
      stringVariable('ChangeTicket2') {
        required false
        showOnReleaseStart false
      }
    }
    scheduledStartDate Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", '2016-04-02T13:00:00+0000')
    phases {
      phase('Create Change') {
        color '#68b749'
        tasks {
          custom('Create Change Ticket') {
            script {
              type 'servicenow.CreateChangeRequest'
              shortDescription '${short_description}'
              comments '${comment}'
              sysId variable('sysId')
              'Ticket' variable('ChangeTicket')
            }
          }
          custom('Create Task on ${ChangeTicket}') {
            script {
              type 'servicenow.CreateTask'
              content '{\n' +
                      '    "change_request" : "${sysId}",\n' +
                      '     "short_description" : "Deploy all INSTALL VERSIONS for the IDM components",\n' +
                      '     "description": "This is a description of the work to be done in this task"\n' +
                      '}'
              taskId variable('taskId')
              'Task' variable('TaskNumber')
            }
          }
          gate('Verify ${ChangeTicket} & ${TaskNumber}') {
            conditions {
              condition('${ChangeTicket}')
              condition('${TaskNumber}')
            }
          }
          custom('Check for approval on ${ChangeTicket}') {
            script {
              type 'servicenow.PollingCheckStatus'
              sysId '${sysId}'
              checkForStatus '1'
            }
          }
        }
      }
      phase('Process Change') {
        color '#009CDB'
        tasks {
          custom('Close Task ${TaskNumber}') {
            script {
              type 'servicenow.UpdateTask'
              sysId '${taskId}'
              content '{\n' +
                      '\'state\':\'3\',\n' +
                      '\'phase_state\':\'close complete\',\n' +
                      '\'work_notes\':\'Updated By XLRelease\'\n' +
                      '}'
            }
          }
          script('Deploy Application from Custom Script') {
            script 'print "#Executing Deployment Script#\\n"\n' +
                   'print "**DONE**\\n"'
          }
          custom('Close Change ${ChangeTicket}') {
            script {
              type 'servicenow.UpdateChangeRequest'
              sysId '${sysId}'
              content '{\n' +
                      '\'state\':\'3\',\n' +
                      '\'phase_state\':\'close complete\',\n' +
                      '\'work_notes\':\'Updated By XLRelease\'\n' +
                      '}'
            }
          }
          gate('Verify ${ChangeTicket} & ${TaskNumber}') {
            conditions {
              condition('${ChangeTicket}')
              condition('${TaskNumber}')
            }
          }
        }
      }
      phase('Create Another Change') {
        color '#ff9e3b'
        tasks {
          custom('Request Approval') {
            script {
              type 'servicenow.RequestApproval'
              shortDescription '${short_description}'
              description '${comment}'
              sysId variable('sysId2')
              ticket variable('ChangeTicket2')
            }
          }
          custom('Update Change Request ${ChangeTicket2}') {
            script {
              type 'servicenow.UpdateChangeRequest'
              sysId '${sysId2}'
              content '{\n' +
                      '\'state\':\'3\',\n' +
                      '\'phase_state\':\'close complete\',\n' +
                      '\'work_notes\':\'Updated By XLRelease\'\n' +
                      '}'
            }
          }
          gate('Verify ${ChangeTicket2}') {
            conditions {
              condition('${ChangeTicket2}')
            }
          }
          manual('T1') {
            
          }
        }
      }
      phase('Post Release Update CMDB') {
        color '#009CDB'
        tasks {
          custom('CMDB Update') {
            script {
              type 'servicenow.UpdateCMDB'
              environment 'TEST'
              applicationName 'MyApplication'
              company 'XebiaLabs'
              configAdminGroup 'xldeploy'
              version '5.1.0'
              virtualMachine 'vm1'
              tomcat 'tomcat-8.1.2'
              mysql 'mysql-7.2.3'
              cfSpace 'Bob'
            }
          }
        }
      }
    }
    teams {
      team('Template Owner') {
        members 'admin'
        permissions 'template#edit', 'template#view', 'template#edit_triggers', 'template#edit_security', 'template#create_release'
      }
      team('Release Admin') {
        permissions 'release#edit', 'release#start', 'release#reassign_task', 'template#view', 'release#edit_security', 'release#abort', 'release#view', 'release#edit_task'
      }
    }
  }
}