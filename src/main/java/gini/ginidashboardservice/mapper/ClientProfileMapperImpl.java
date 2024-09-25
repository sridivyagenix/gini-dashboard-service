package gini.ginidashboardservice.mapper;
import gini.ginidashboardservice.dto.ClientProfileDTO;
import gini.ginidashboardservice.models.ClientProfile;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class ClientProfileMapperImpl implements ClientProfileMapper {
    public ClientProfileMapperImpl() {
    }

    public ClientProfile toEntity(ClientProfileDTO dto) {
        if (dto == null) {
            return null;
        } else {
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setCompanyId(dto.getCompanyId());
            clientProfile.setEmployeeId(dto.getEmployeeId());
            clientProfile.setAgentId(dto.getAgentId());
            clientProfile.setFullName(dto.getFullName());
            clientProfile.setDob(dto.getDob());
            clientProfile.setTaxId(dto.getTaxId());
            clientProfile.setGender(dto.getGender());
            clientProfile.setMaritalStatus(dto.getMaritalStatus());
            clientProfile.setPhone(dto.getPhone());
            clientProfile.setEmail(dto.getEmail());
            clientProfile.setOccupation(dto.getOccupation());
            clientProfile.setAnnualIncome(dto.getAnnualIncome());
            Map<String, Object> map = dto.getAddress();
            if (map != null) {
                clientProfile.setAddress(new LinkedHashMap(map));
            }

            Map<String, Object> map1 = dto.getEmployer();
            if (map1 != null) {
                clientProfile.setEmployer(new LinkedHashMap(map1));
            }

            List<Map<String, Object>> list = dto.getInsuranceCoverageDetails();
            if (list != null) {
                clientProfile.setInsuranceCoverageDetails(new ArrayList(list));
            }

            Map<String, Object> map2 = dto.getBeneficiaries();
            if (map2 != null) {
                clientProfile.setBeneficiaries(new LinkedHashMap(map2));
            }

            Map<String, Object> map3 = dto.getEducation();
            if (map3 != null) {
                clientProfile.setEducation(new LinkedHashMap(map3));
            }

            Map<String, Object> map4 = dto.getHealthInfo();
            if (map4 != null) {
                clientProfile.setHealthInfo(new LinkedHashMap(map4));
            }

            Map<String, Object> map5 = dto.getLifestyleBackgroundInfo();
            if (map5 != null) {
                clientProfile.setLifestyleBackgroundInfo(new LinkedHashMap(map5));
            }

            Map<String, Object> map6 = dto.getDeclarations();
            if (map6 != null) {
                clientProfile.setDeclarations(new LinkedHashMap(map6));
            }

            List<Map<String, Object>> list1 = dto.getChildren();
            if (list1 != null) {
                clientProfile.setChildren(new ArrayList(list1));
            }

            Map<String, Object> map7 = dto.getSavings();
            if (map7 != null) {
                clientProfile.setSavings(new LinkedHashMap(map7));
            }

            Map<String, Object> map8 = dto.getMonthlyExpenses();
            if (map8 != null) {
                clientProfile.setMonthlyExpenses(new LinkedHashMap(map8));
            }

            Map<String, Object> map9 = dto.getInsuranceGoals();
            if (map9 != null) {
                clientProfile.setInsuranceGoals(new LinkedHashMap(map9));
            }

            Map<String, Object> map10 = dto.getRetirementGoals();
            if (map10 != null) {
                clientProfile.setRetirementGoals(new LinkedHashMap(map10));
            }

            Map<String, Object> map11 = dto.getInvestmentGoals();
            if (map11 != null) {
                clientProfile.setInvestmentGoals(new LinkedHashMap(map11));
            }

            Map<String, Object> map12 = dto.getRiskAppetite();
            if (map12 != null) {
                clientProfile.setRiskAppetite(new LinkedHashMap(map12));
            }

            Map<String, Object> map13 = dto.getFinancialGoals();
            if (map13 != null) {
                clientProfile.setFinancialGoals(new LinkedHashMap(map13));
            }

            clientProfile.setAdditionalInfo(dto.getAdditionalInfo());
            clientProfile.setProfileCreatedDt(dto.getProfileCreatedDt());
            clientProfile.setProfileUpdatedDt(dto.getProfileUpdatedDt());
            Map<String, Object> map14 = dto.getComplete_customer_profile();
            if (map14 != null) {
                clientProfile.setComplete_customer_profile(new LinkedHashMap(map14));
            }

            clientProfile.setCreatedAt(dto.getCreatedAt());
            clientProfile.setLastModifiedAt(dto.getLastModifiedAt());
            clientProfile.setConvId(dto.getConvId());
            return clientProfile;
        }
    }

    public ClientProfileDTO toDto(ClientProfile entity) {
        if (entity == null) {
            return null;
        } else {
            ClientProfileDTO clientProfileDTO = new ClientProfileDTO();
            clientProfileDTO.setCompanyId(entity.getCompanyId());
            clientProfileDTO.setEmployeeId(entity.getEmployeeId());
            clientProfileDTO.setAgentId(entity.getAgentId());
            clientProfileDTO.setFullName(entity.getFullName());
            clientProfileDTO.setDob(entity.getDob());
            clientProfileDTO.setTaxId(entity.getTaxId());
            clientProfileDTO.setGender(entity.getGender());
            clientProfileDTO.setMaritalStatus(entity.getMaritalStatus());
            clientProfileDTO.setPhone(entity.getPhone());
            clientProfileDTO.setEmail(entity.getEmail());
            clientProfileDTO.setOccupation(entity.getOccupation());
            clientProfileDTO.setAnnualIncome(entity.getAnnualIncome());
            Map<String, Object> map = entity.getAddress();
            if (map != null) {
                clientProfileDTO.setAddress(new LinkedHashMap(map));
            }

            Map<String, Object> map1 = entity.getEmployer();
            if (map1 != null) {
                clientProfileDTO.setEmployer(new LinkedHashMap(map1));
            }

            List<Map<String, Object>> list = entity.getInsuranceCoverageDetails();
            if (list != null) {
                clientProfileDTO.setInsuranceCoverageDetails(new ArrayList(list));
            }

            Map<String, Object> map2 = entity.getBeneficiaries();
            if (map2 != null) {
                clientProfileDTO.setBeneficiaries(new LinkedHashMap(map2));
            }

            Map<String, Object> map3 = entity.getEducation();
            if (map3 != null) {
                clientProfileDTO.setEducation(new LinkedHashMap(map3));
            }

            Map<String, Object> map4 = entity.getHealthInfo();
            if (map4 != null) {
                clientProfileDTO.setHealthInfo(new LinkedHashMap(map4));
            }

            Map<String, Object> map5 = entity.getLifestyleBackgroundInfo();
            if (map5 != null) {
                clientProfileDTO.setLifestyleBackgroundInfo(new LinkedHashMap(map5));
            }

            Map<String, Object> map6 = entity.getDeclarations();
            if (map6 != null) {
                clientProfileDTO.setDeclarations(new LinkedHashMap(map6));
            }

            List<Map<String, Object>> list1 = entity.getChildren();
            if (list1 != null) {
                clientProfileDTO.setChildren(new ArrayList(list1));
            }

            Map<String, Object> map7 = entity.getSavings();
            if (map7 != null) {
                clientProfileDTO.setSavings(new LinkedHashMap(map7));
            }

            Map<String, Object> map8 = entity.getMonthlyExpenses();
            if (map8 != null) {
                clientProfileDTO.setMonthlyExpenses(new LinkedHashMap(map8));
            }

            Map<String, Object> map9 = entity.getInsuranceGoals();
            if (map9 != null) {
                clientProfileDTO.setInsuranceGoals(new LinkedHashMap(map9));
            }

            Map<String, Object> map10 = entity.getRetirementGoals();
            if (map10 != null) {
                clientProfileDTO.setRetirementGoals(new LinkedHashMap(map10));
            }

            Map<String, Object> map11 = entity.getInvestmentGoals();
            if (map11 != null) {
                clientProfileDTO.setInvestmentGoals(new LinkedHashMap(map11));
            }

            Map<String, Object> map12 = entity.getRiskAppetite();
            if (map12 != null) {
                clientProfileDTO.setRiskAppetite(new LinkedHashMap(map12));
            }

            Map<String, Object> map13 = entity.getFinancialGoals();
            if (map13 != null) {
                clientProfileDTO.setFinancialGoals(new LinkedHashMap(map13));
            }

            clientProfileDTO.setAdditionalInfo(entity.getAdditionalInfo());
            clientProfileDTO.setProfileCreatedDt(entity.getProfileCreatedDt());
            clientProfileDTO.setProfileUpdatedDt(entity.getProfileUpdatedDt());
            Map<String, Object> map14 = entity.getComplete_customer_profile();
            if (map14 != null) {
                clientProfileDTO.setComplete_customer_profile(new LinkedHashMap(map14));
            }

            clientProfileDTO.setCreatedAt(entity.getCreatedAt());
            clientProfileDTO.setLastModifiedAt(entity.getLastModifiedAt());
            clientProfileDTO.setConvId(entity.getConvId());
            return clientProfileDTO;
        }
    }

    public void updateClientProfileFromDto(ClientProfileDTO dto, ClientProfile entity) {
        if (dto != null) {
            entity.setCompanyId(dto.getCompanyId());
            entity.setEmployeeId(dto.getEmployeeId());
            entity.setAgentId(dto.getAgentId());
            entity.setFullName(dto.getFullName());
            entity.setDob(dto.getDob());
            entity.setTaxId(dto.getTaxId());
            entity.setGender(dto.getGender());
            entity.setMaritalStatus(dto.getMaritalStatus());
            entity.setPhone(dto.getPhone());
            entity.setEmail(dto.getEmail());
            entity.setOccupation(dto.getOccupation());
            entity.setAnnualIncome(dto.getAnnualIncome());
            Map map14;
            if (entity.getAddress() != null) {
                map14 = dto.getAddress();
                if (map14 != null) {
                    entity.getAddress().clear();
                    entity.getAddress().putAll(map14);
                } else {
                    entity.setAddress((Map)null);
                }
            } else {
                map14 = dto.getAddress();
                if (map14 != null) {
                    entity.setAddress(new LinkedHashMap(map14));
                }
            }

            if (entity.getEmployer() != null) {
                map14 = dto.getEmployer();
                if (map14 != null) {
                    entity.getEmployer().clear();
                    entity.getEmployer().putAll(map14);
                } else {
                    entity.setEmployer((Map)null);
                }
            } else {
                map14 = dto.getEmployer();
                if (map14 != null) {
                    entity.setEmployer(new LinkedHashMap(map14));
                }
            }

            List list1;
            if (entity.getInsuranceCoverageDetails() != null) {
                list1 = dto.getInsuranceCoverageDetails();
                if (list1 != null) {
                    entity.getInsuranceCoverageDetails().clear();
                    entity.getInsuranceCoverageDetails().addAll(list1);
                } else {
                    entity.setInsuranceCoverageDetails((List)null);
                }
            } else {
                list1 = dto.getInsuranceCoverageDetails();
                if (list1 != null) {
                    entity.setInsuranceCoverageDetails(new ArrayList(list1));
                }
            }

            if (entity.getBeneficiaries() != null) {
                map14 = dto.getBeneficiaries();
                if (map14 != null) {
                    entity.getBeneficiaries().clear();
                    entity.getBeneficiaries().putAll(map14);
                } else {
                    entity.setBeneficiaries((Map)null);
                }
            } else {
                map14 = dto.getBeneficiaries();
                if (map14 != null) {
                    entity.setBeneficiaries(new LinkedHashMap(map14));
                }
            }

            if (entity.getEducation() != null) {
                map14 = dto.getEducation();
                if (map14 != null) {
                    entity.getEducation().clear();
                    entity.getEducation().putAll(map14);
                } else {
                    entity.setEducation((Map)null);
                }
            } else {
                map14 = dto.getEducation();
                if (map14 != null) {
                    entity.setEducation(new LinkedHashMap(map14));
                }
            }

            if (entity.getHealthInfo() != null) {
                map14 = dto.getHealthInfo();
                if (map14 != null) {
                    entity.getHealthInfo().clear();
                    entity.getHealthInfo().putAll(map14);
                } else {
                    entity.setHealthInfo((Map)null);
                }
            } else {
                map14 = dto.getHealthInfo();
                if (map14 != null) {
                    entity.setHealthInfo(new LinkedHashMap(map14));
                }
            }

            if (entity.getLifestyleBackgroundInfo() != null) {
                map14 = dto.getLifestyleBackgroundInfo();
                if (map14 != null) {
                    entity.getLifestyleBackgroundInfo().clear();
                    entity.getLifestyleBackgroundInfo().putAll(map14);
                } else {
                    entity.setLifestyleBackgroundInfo((Map)null);
                }
            } else {
                map14 = dto.getLifestyleBackgroundInfo();
                if (map14 != null) {
                    entity.setLifestyleBackgroundInfo(new LinkedHashMap(map14));
                }
            }

            if (entity.getDeclarations() != null) {
                map14 = dto.getDeclarations();
                if (map14 != null) {
                    entity.getDeclarations().clear();
                    entity.getDeclarations().putAll(map14);
                } else {
                    entity.setDeclarations((Map)null);
                }
            } else {
                map14 = dto.getDeclarations();
                if (map14 != null) {
                    entity.setDeclarations(new LinkedHashMap(map14));
                }
            }

            if (entity.getChildren() != null) {
                list1 = dto.getChildren();
                if (list1 != null) {
                    entity.getChildren().clear();
                    entity.getChildren().addAll(list1);
                } else {
                    entity.setChildren((List)null);
                }
            } else {
                list1 = dto.getChildren();
                if (list1 != null) {
                    entity.setChildren(new ArrayList(list1));
                }
            }

            if (entity.getSavings() != null) {
                map14 = dto.getSavings();
                if (map14 != null) {
                    entity.getSavings().clear();
                    entity.getSavings().putAll(map14);
                } else {
                    entity.setSavings((Map)null);
                }
            } else {
                map14 = dto.getSavings();
                if (map14 != null) {
                    entity.setSavings(new LinkedHashMap(map14));
                }
            }

            if (entity.getMonthlyExpenses() != null) {
                map14 = dto.getMonthlyExpenses();
                if (map14 != null) {
                    entity.getMonthlyExpenses().clear();
                    entity.getMonthlyExpenses().putAll(map14);
                } else {
                    entity.setMonthlyExpenses((Map)null);
                }
            } else {
                map14 = dto.getMonthlyExpenses();
                if (map14 != null) {
                    entity.setMonthlyExpenses(new LinkedHashMap(map14));
                }
            }

            if (entity.getInsuranceGoals() != null) {
                map14 = dto.getInsuranceGoals();
                if (map14 != null) {
                    entity.getInsuranceGoals().clear();
                    entity.getInsuranceGoals().putAll(map14);
                } else {
                    entity.setInsuranceGoals((Map)null);
                }
            } else {
                map14 = dto.getInsuranceGoals();
                if (map14 != null) {
                    entity.setInsuranceGoals(new LinkedHashMap(map14));
                }
            }

            if (entity.getRetirementGoals() != null) {
                map14 = dto.getRetirementGoals();
                if (map14 != null) {
                    entity.getRetirementGoals().clear();
                    entity.getRetirementGoals().putAll(map14);
                } else {
                    entity.setRetirementGoals((Map)null);
                }
            } else {
                map14 = dto.getRetirementGoals();
                if (map14 != null) {
                    entity.setRetirementGoals(new LinkedHashMap(map14));
                }
            }

            if (entity.getInvestmentGoals() != null) {
                map14 = dto.getInvestmentGoals();
                if (map14 != null) {
                    entity.getInvestmentGoals().clear();
                    entity.getInvestmentGoals().putAll(map14);
                } else {
                    entity.setInvestmentGoals((Map)null);
                }
            } else {
                map14 = dto.getInvestmentGoals();
                if (map14 != null) {
                    entity.setInvestmentGoals(new LinkedHashMap(map14));
                }
            }

            if (entity.getRiskAppetite() != null) {
                map14 = dto.getRiskAppetite();
                if (map14 != null) {
                    entity.getRiskAppetite().clear();
                    entity.getRiskAppetite().putAll(map14);
                } else {
                    entity.setRiskAppetite((Map)null);
                }
            } else {
                map14 = dto.getRiskAppetite();
                if (map14 != null) {
                    entity.setRiskAppetite(new LinkedHashMap(map14));
                }
            }

            if (entity.getFinancialGoals() != null) {
                map14 = dto.getFinancialGoals();
                if (map14 != null) {
                    entity.getFinancialGoals().clear();
                    entity.getFinancialGoals().putAll(map14);
                } else {
                    entity.setFinancialGoals((Map)null);
                }
            } else {
                map14 = dto.getFinancialGoals();
                if (map14 != null) {
                    entity.setFinancialGoals(new LinkedHashMap(map14));
                }
            }

            entity.setAdditionalInfo(dto.getAdditionalInfo());
            entity.setProfileCreatedDt(dto.getProfileCreatedDt());
            entity.setProfileUpdatedDt(dto.getProfileUpdatedDt());
            if (entity.getComplete_customer_profile() != null) {
                map14 = dto.getComplete_customer_profile();
                if (map14 != null) {
                    entity.getComplete_customer_profile().clear();
                    entity.getComplete_customer_profile().putAll(map14);
                } else {
                    entity.setComplete_customer_profile((Map)null);
                }
            } else {
                map14 = dto.getComplete_customer_profile();
                if (map14 != null) {
                    entity.setComplete_customer_profile(new LinkedHashMap(map14));
                }
            }

            entity.setCreatedAt(dto.getCreatedAt());
            entity.setLastModifiedAt(dto.getLastModifiedAt());
            entity.setConvId(dto.getConvId());
        }
    }
}



