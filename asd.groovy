// Exported from:        http://Chitrangs-MacBook-Pro.local:5516/#/templates/Folderd2c2f73be2ae4d5692b2353f6a8303f2-Folder700e84cbc0d24eb3bd925875ae7a3e6a-Release5cdcf5343a6a4ffcadbffe081d89b5c7/releasefile
// XL Release version:   8.1.0-SNAPSHOT
// Date created:         Fri Jun 08 09:38:05 CEST 2018

def riskProfile(title) {
    riskApi.getRiskProfileByTitle(title)
}

def riskProfile1 = riskProfile('RP1')
def scmConnectorConfig1 = 'PLEASE IMPLEMENT THIS METHOD'

xlr {
  template('asd') {
    folder('f1/f2')
    scheduledStartDate Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", '2018-06-08T09:00:00+0200')
    riskProfile riskProfile1
    scmConnectorConfig scmConnectorConfig1
    phases {
      phase('New Phase') {
        tasks {
          manual('T1') {
            
          }
          externalScript('T2') {
            
          }
          manual('T3') {
            
          }
        }
      }
      phase('New Phase') {
        tasks {
          manual('T1') {
            
          }
          manual('T2') {
            
          }
          manual('T3') {
            
          }
        }
      }
      phase('New Phase') {
        tasks {
          manual('T1') {
            
          }
          manual('T2') {
            
          }
          manual('T3') {
            
          }
        }
      }
      phase('New Phase') {
        tasks {
          manual('T1') {
            
          }
          manual('T2') {
            
          }
          manual('T3') {
            
          }
        }
      }
      phase('New Phase') {
        tasks {
          manual('T1') {
            
          }
          manual('T2') {
            
          }
          manual('T3') {
            
          }
        }
      }
      phase('New Phase') {
        tasks {
          manual('T1') {
            
          }
          manual('T2') {
            
          }
          manual('T3') {
            
          }
        }
      }
      phase('New Phase') {
        tasks {
          manual('T1') {
            
          }
          manual('T2') {
            
          }
          manual('T3') {
            
          }
        }
      }
    }
    
  }
}