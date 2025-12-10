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
    "subnet-0c78704eccb15873f",  # us-east-1a
    "subnet-03bc79cd9cbbe2120",  # us-east-1b
    "subnet-0246689e109765dcd"   # us-east-1c
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
  default     = "vpc-02f3ac5a4235b04b8"
}

variable "vpc_cidr" {
  description = "CIDR block for the VPC"
  type        = string
  default     = "10.0.0.0/16"
}
