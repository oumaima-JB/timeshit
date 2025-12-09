variable "aws_region" {
  description = "La région AWS"
  type        = string
  default     = "us-east-1"
}

variable "cluster_name" {
  description = "Nom du cluster EKS"
  type        = string
  default     = "mykubernetes"
}

variable "subnet_ids" {
  description = "IDs des sous-réseaux EKS"
  type        = list(string)
  default     = [
    "subnet-02e9c50e3c4c9b4ff",  # us-east-1a
    "subnet-098ef0c3178744a0c",  # us-east-1b
    "subnet-028159a7caffd0d08"   # us-east-1c
  ]
}

variable "role_arn" {
  description = "ARN du rôle IAM pour EKS"
  type        = string
  default     = "arn:aws:iam::740749044628:role/LabRole"
}

variable "vpc_id" {
  description = "ID du VPC"
  type        = string
  default     = "vpc-0fd1b5ec63384ce92"
}

variable "vpc_cidr" {
  description = "CIDR block for the VPC"
  type        = string
  default     = "10.0.0.0/16"
}
